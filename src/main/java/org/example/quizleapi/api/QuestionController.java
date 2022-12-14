package org.example.quizleapi.api;

import com.google.gson.Gson;
import org.example.quizleapi.business.QuestionService;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.example.quizleapi.questions.Question;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.example.quizleapi.business.QuestionService.QUESTIONSET_PER_DEFAULT;

public class QuestionController extends AbstractHandler {

    public static final String CONTEXT_PATH = "/api/v1/questions";

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IllegalArgumentException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String n = request.getParameter("n");
        int numberOfQuestions = QUESTIONSET_PER_DEFAULT;
        if (n != null && !n.isEmpty()) {
            if (isValidNumberOfQuestions(n)) {
                numberOfQuestions = Integer.parseInt(n);
            } else {
                response.sendError(400, "Invalid Input. n is no a number.");
                baseRequest.setHandled(true);
                return;
            }
        }

        String[] x = request.getParameterValues("x");
        List<UUID> excludedIDs = new ArrayList<>();
        if (x != null && x.length > 0) {
            if (hasValidIDs(x)) {
                for (String stringID : x) {
                    excludedIDs.add(UUID.fromString(stringID));
                }
            } else {
                response.sendError(400, "Invalid Input. List of UUIDs are incomplete or incorrect.");
                baseRequest.setHandled(true);
                return;
            }
        }

        try {
            List<Question> questions = questionService.assembleQuestions(numberOfQuestions, excludedIDs);
            response.getWriter().println(new Gson().toJson(new QuestionWrapper(questions)));

            baseRequest.setHandled(true);
        } catch (IllegalArgumentException e) {
            response.sendError(400, e.getMessage());
            baseRequest.setHandled(true);
        }
    }

    //this method returns true if the number is greater than zero
    public static boolean isValidNumberOfQuestions(String n) {
        try {
            int number = Integer.parseInt(n);
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean hasValidIDs(String[] excludedIDs) {

        for (String id : excludedIDs) {

            try {
                if (id == null) {
                    return false;
                }
                UUID uuid = UUID.fromString(id);
            } catch (IllegalArgumentException exception) {
                return false;
            }
        }
        return true;
    }
}

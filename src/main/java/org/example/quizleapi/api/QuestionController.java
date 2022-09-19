package org.example.quizleapi.api;

import com.google.gson.Gson;
import org.example.quizleapi.business.QuestionService;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.example.quizleapi.questions.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String n = request.getParameter("n");
        int numberOfQuestions = QUESTIONSET_PER_DEFAULT;
        if (n.length() != 0) {
            if (isValidNumberOfQuestions(n)) {
                numberOfQuestions = Integer.parseInt(n);
            } else {
                response.sendError(400, "Bad Request");
                baseRequest.setHandled(true);
                return;
            }
        }

        String[] x = request.getParameterValues("x");
        List<UUID> excludedIDs = new ArrayList<>();
        if (x != null) {
            if (hasValidIDs(x)) {
                for (String stringID : x) {
                    excludedIDs.add(UUID.fromString(stringID));
                }
            } else {
                response.sendError(400, "Bad Request");
                baseRequest.setHandled(true);
                return;
            }
        }

        List<Question> questions = questionService.assembleQuestions(numberOfQuestions, excludedIDs);

        response.getWriter().println(new Gson().toJson(new QuestionWrapper(questions)));

        baseRequest.setHandled(true);
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
                if (id.length() == 0) {
                    continue;
                }
                UUID.fromString(id);
            } catch (IllegalArgumentException exception) {
                return false;
            }
        }
        return true;
    }


    public static class QuestionWrapper {

        private final List<Question> questions;

        public QuestionWrapper(List<Question> questions) {
            this.questions = questions;
        }

        public List<Question> getQuestions() {
            return questions;
        }
    }
}

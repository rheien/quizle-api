package org.example.quizleapi.api;

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

        response.getWriter().println("n: " + request.getParameter("n"));
        response.getWriter().println("x: " + request.getParameterValues("x"));

        //int numberOfQuestions = validNumber(request.getParameter("n"));
        //validID();

        response.getWriter().println();

        List<Question> questions = questionService.assembleQuestions(9, new ArrayList<UUID>());
        List<UUID> blacklists = new ArrayList<UUID>();
        for (Question question : questions) {
            response.getWriter().println(question.id);
            blacklists.add(question.id);
        }

        response.getWriter().println();

        baseRequest.setHandled(true);
    }


    public int validNumber(String numberOfQuestions) throws IOException {
        if (!isNumeric(numberOfQuestions)) {
            throw new IOException("Invalid number");
        }
        if (numberOfQuestions.length() == 0) {
            return QuestionService.QUESTIONSET_PER_DEFAULT;
        }
        return Integer.parseInt(numberOfQuestions);
    }

    //this method returns true if string is not null. smaller than zero and only an integer
    public boolean isNumeric(String str) {
        return str != null && str.matches("^[1-9][0-9]*$");
    }

    public void validID(String[] excludedIDs) {
        for (String id : excludedIDs) {
            try {
                UUID uuid = UUID.fromString(id);
            } catch (IllegalArgumentException exception) {

            }
        }
    }
}

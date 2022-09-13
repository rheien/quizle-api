package org.example.quizleapi.api;

import org.example.quizleapi.business.QuestionService;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.example.quizleapi.questions.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

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

        response.getWriter().println("Hello " + request.getRemoteAddr() + "!");

        response.getWriter().println("Current time: " + LocalDateTime.now());

        List<Question> questions = questionService.assembleQuestions(6,new UUID[]{});
        List<UUID> blacklists = new ArrayList<UUID>();
        for (Question value : questions) {
            response.getWriter().println(value.id);
            blacklists.add(value.id);
        }

        response.getWriter().println();
        UUID[] excludedIDs= blacklists.toArray(new UUID[blacklists.size()]);
        List<Question> questions2 = questionService.assembleQuestions(6,excludedIDs);
        for (Question question : questions2) {
            response.getWriter().println(question.id);
        }

        response.getWriter().println();

        baseRequest.setHandled(true);
    }
}

package org.example.quizleapi.api;

import org.example.quizleapi.business.QuestionService;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.example.quizleapi.questions.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

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
        for (int i = 0; i < questions.size(); i++) {
            response.getWriter().println(questions.get(i).id);
        }

        response.getWriter().println();

        baseRequest.setHandled(true);
    }
}

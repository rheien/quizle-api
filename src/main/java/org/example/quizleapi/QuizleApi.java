package org.example.quizleapi;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.example.quizleapi.api.QuestionController;
import org.example.quizleapi.business.QuestionService;
import org.example.quizleapi.business.RandomQuestionService;

//setting a server
public class QuizleApi {

    public static void main(String[] args) throws Exception {

        QuestionService questionService = new RandomQuestionService();

        final ContextHandler context = new ContextHandler();
        context.setContextPath(QuestionController.CONTEXT_PATH);
        context.setHandler(new QuestionController(questionService));

        final String port = System.getenv().getOrDefault("PORT", "8888");
        final Server server = new Server(Integer.parseInt(port));
        server.setHandler(context);
        server.start();
        server.join();
    }

}
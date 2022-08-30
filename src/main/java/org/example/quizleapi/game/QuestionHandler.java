package org.example.quizleapi.game;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class QuestionHandler extends AbstractHandler {
    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("Hello " + request.getRemoteAddr() + "!");

        response.getWriter().println("Current time: " + LocalDateTime.now());

        baseRequest.setHandled(true);
    }
}

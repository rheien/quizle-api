package org.example.quizleapi;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.example.quizleapi.game.QuestionHandler;

//setting a server
public class JettyServer {

    public static void main(String[] args) throws Exception {

        final ContextHandler context = new ContextHandler();
        context.setContextPath("/api/v1/questions");
        context.setHandler(new QuestionHandler());

        final String port = System.getenv().getOrDefault("PORT", "8888");
        final Server server = new Server(Integer.parseInt(port));
        server.setHandler(context);
        server.start();
        server.join();
    }

}
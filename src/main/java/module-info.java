module org.example.quizleapi {
    requires javafx.controls;
    requires javafx.fxml;
    requires javax.servlet.api;
    requires org.eclipse.jetty.server;


    opens org.example.quizleapi to javafx.fxml;
    exports org.example.quizleapi;
}
module org.example.quizleapi {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.quizleapi to javafx.fxml;
    exports org.example.quizleapi;
}
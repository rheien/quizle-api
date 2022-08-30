package org.example.quizleapi.api.v1.questions;

public interface Question {
    String question();
    String[] answers();
    String[] correctAnswers();
    QuestionType questionType();
}

package org.example.quizleapi.api;

import org.example.quizleapi.questions.Question;

import java.util.List;

public class QuestionWrapper {

    private final List<Question> questions;

    public QuestionWrapper(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}

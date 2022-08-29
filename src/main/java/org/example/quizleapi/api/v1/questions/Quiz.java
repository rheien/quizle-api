package org.example.quizleapi.api.v1.questions;

public class Quiz implements Question {
    public final String[] questions;
    static int round;
    static int maxRound;

    public Quiz(String[] questions, int round, int maxRound) {
        this.questions = questions;
        Quiz.round = round;
        Quiz.maxRound = maxRound;
    }

    public String question() {
        return this.question;
    }

}

package org.example.quizleapi.api.v1.questions;

public class Quiz implements Question {
    public static Question questions;
    static int round;
    static int maxRound;
    private String[] answers;
    private String question;
    private String[] correctAnswers;
    private QuestionType questionType;

    public Quiz() {
    }

    public Quiz(Question questions) {
        Quiz.questions = questions;
    }

    public Quiz(Question questions, int maxRound) {
        this.questions = questions;
        Quiz.maxRound = maxRound;
    }

    public Quiz(Question questions, int round, int maxRound) {
        this.questions = questions;
        Quiz.round = round;
        Quiz.maxRound = maxRound;
    }

    public String question() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] answers() {
        return answers;
    }

    public void setAnswer(String[] answers) {
        this.answers = answers;
    }

    public String[] correctAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(String[] correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public QuestionType questionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }


}

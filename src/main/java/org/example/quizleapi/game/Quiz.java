package org.example.quizleapi.api.v1.questions.game;

import org.example.quizleapi.api.v1.questions.questions.Question;
import org.example.quizleapi.api.v1.questions.questions.QuestionType;

import java.util.ArrayList;

public class Quiz implements Question {
    public static Question questions;
    static int round;
    static int maxRound;
    private ArrayList<String> answers;
    private String question;
    private ArrayList<String> correctAnswers;
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

    public ArrayList<String> answers() {
        return answers;
    }

    public void setAnswer(ArrayList<String> answers) {
        this.answers = answers;
    }

    public ArrayList<String> correctAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(ArrayList<String> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public QuestionType questionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    @Override
    public void question(String question, QuestionType questionType) {

    }
}

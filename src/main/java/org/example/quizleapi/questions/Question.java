package org.example.quizleapi.questions;

public class Question {

    public final String question;
    public final String[] answers;
    public final String[] correctAnswers;
    public final QuestionType questionType;

    public Question(String question,
                    String[] answers,
                    String[] correctAnswers,
                    QuestionType questionType) {

        this.question = question;
        this.answers = answers;
        this.correctAnswers = correctAnswers;
        this.questionType = questionType;
    }

}

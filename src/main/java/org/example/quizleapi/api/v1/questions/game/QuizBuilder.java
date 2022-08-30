package org.example.quizleapi.api.v1.questions;

import java.util.ArrayList;

public class QuizBuilder extends Quiz {

    protected static int QUESTIONS_PER_TYPE = 2;

    public QuizBuilder(Question questions, int maxRound) {
        super(questions, maxRound);
    }

    public static Question buildQuiz() {

        ArrayList<Question> questions = new ArrayList<Question>();



        return (Question) questions;
    }

    public static Question poseQuestions(Question question) {

        Question questions;
        String question;

        for (int index = 0; index < QUESTIONS_PER_TYPE; index++) {
            int pickNumber = (int) (Math.random() * maxRound);

            question = questions[pickNumber];

        }


    }
}

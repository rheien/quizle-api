package org.example.quizleapi.business;

import org.example.quizleapi.questions.Question;

public class RandomQuestionService implements QuestionService{

    @Override
    public Question[] assembleQuestions(int numberOfQuestions, Question[] excludedQuestions) {
        return new Question[0];
    }
}

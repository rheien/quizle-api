package org.example.quizleapi.business;

import org.example.quizleapi.questions.Question;

public interface QuestionService {

    Question[] assembleQuestions(int numberOfQuestions, Question[] excludedQuestions);
}

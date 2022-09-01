package org.example.quizleapi.business;

import org.example.quizleapi.questions.Question;

import java.util.List;

public interface QuestionService {

    List<Question> assembleQuestions(int numberOfQuestions, String[] excludedQuestions);
}

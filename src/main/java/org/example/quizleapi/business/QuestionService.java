package org.example.quizleapi.business;

import org.example.quizleapi.questions.Question;

import java.util.List;
import java.util.UUID;

public interface QuestionService {

    List<Question> assembleQuestions(int numberOfQuestions, UUID[] excludedQuestions);
}

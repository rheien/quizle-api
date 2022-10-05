package org.example.quizleapi.business;

import org.example.quizleapi.questions.Question;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface QuestionService {

    int QUESTIONSET_PER_DEFAULT = 6;

    List<Question> assembleQuestions(int numberOfQuestions, List<UUID> excludedQuestions) throws IllegalArgumentException;
}

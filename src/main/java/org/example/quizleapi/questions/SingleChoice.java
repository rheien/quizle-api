package org.example.quizleapi.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleChoice {

    public static final List<Question> SINGLE_CHOICE_QUESTIONS = Arrays.asList(
            new Question(
                    "Wie schreibt man",
                    new String[] {"Portemonnaie",
                            "Portmonnaie",
                            "Portemonaie"},
                    new String[] {"Portemonnaie"},
                    QuestionType.SINGLE_CHOICE
            )
    );

}

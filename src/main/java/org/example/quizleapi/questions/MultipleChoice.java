package org.example.quizleapi.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MultipleChoice {

    public static final List<Question> MULTIPLE_CHOICE_QUESTIONS = Arrays.asList(
            new Question(
                    "Pi = 3,1415...",
                    new String[] {"92",
                            "93",
                            "94",
                            "95"},
                    new String[] {"92"},
                    QuestionType.MULTIPLE_CHOICE
            )
    );

}

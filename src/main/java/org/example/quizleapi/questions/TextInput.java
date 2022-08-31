package org.example.quizleapi.questions;

import java.util.Arrays;
import java.util.List;

public class TextInput {

    public static final List<Question> FREE_TEXT_QUESTIONS = Arrays.asList(
            new Question(
                    "Wie lautet der Vorname von Frau Springer?",
                    new String[] {"Friede"},
                    new String[] {"Friede"},
                    QuestionType.FREE_TEXT
            )
    );

}


package org.example.quizleapi.questions;

import java.util.Arrays;
import java.util.List;

public class TextInput {

    public static final List<Question> FREE_TEXT_QUESTIONS = Arrays.asList(
            new Question(
                    "Wie lautet der Vorname von Frau Springer?",
                    new String[]{"Friede"},
                    new String[]{"Friede"},
                    QuestionType.FREE_TEXT
            ),

            new Question(
                    "Wie heißt die nicht frittierte Variante von der Frühlingsrolle?",
                    new String[]{"Sommerrolle"},
                    new String[]{"Sommerrolle"},
                    QuestionType.FREE_TEXT
            ),

            new Question(
                    "In welcher Sportart nutzt man den 'Fadeaway'?",
                    new String[]{"Basketball"},
                    new String[]{"Basketball"},
                    QuestionType.FREE_TEXT
            ),

            new Question(
                    "In welcher Stadt befindet sich die Goldelse?",
                    new String[]{"Berlin"},
                    new String[]{"Berlin"},
                    QuestionType.FREE_TEXT
            ),

            new Question(
                    "Wie heißt die eSport News App von Upday?",
                    new String[]{"Jaxon"},
                    new String[]{"Jaxon"},
                    QuestionType.FREE_TEXT
            ),

            new Question(
                    "In welchem jahr entstand der Axel Springer Neubau?",
                    new String[]{"2020"},
                    new String[]{"2020"},
                    QuestionType.FREE_TEXT
            ),

            new Question(
                    "Wie lautet die Antwort von dem Supercomputer Deep Thought?",
                    new String[]{"42"},
                    new String[]{"42"},
                    QuestionType.FREE_TEXT
            ),

            new Question(
                    "Wie lautet die Dezimalzahl 42 in Binär?",
                    new String[]{"101010"},
                    new String[]{"101010"},
                    QuestionType.FREE_TEXT
            ),

            new Question(
                    "Wie lautet die Dezimalzahl 42 in Hexadezimal?",
                    new String[]{"2A"},
                    new String[]{"2A"},
                    QuestionType.FREE_TEXT
            ),

            new Question(
                    "Wie lautet die Dezimalzahl 42 in Oktal?",
                    new String[]{"52"},
                    new String[]{"52"},
                    QuestionType.FREE_TEXT
            )

    );

}


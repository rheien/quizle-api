package org.example.quizleapi.questions;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class TextInput {

    public static final List<Question> FREE_TEXT_QUESTIONS = Arrays.asList(
            new Question(
                    UUID.fromString("2FBA748A-C49A-40C0-B8FF-E0F8D32BD83D"),
                    "Wie lautet der Vorname von Frau Springer?",
                    new String[]{"Friede"},
                    new String[]{"Friede"},
                    QuestionType.FREE_TEXT
            ),

            new Question(
                    UUID.fromString("4CCC19A1-4227-4DE8-919F-4E0E1A8EB701"),
                    "Wie heißt die nicht frittierte Variante von der Frühlingsrolle?",
                    new String[]{"Sommerrolle"},
                    new String[]{"Sommerrolle"},
                    QuestionType.FREE_TEXT
            ),

            new Question(
                    UUID.fromString("96F7675C-5488-41E1-8DED-9A3AC9AFE01D"),
                    "In welcher Sportart nutzt man den 'Fadeaway'?",
                    new String[]{"Basketball"},
                    new String[]{"Basketball"},
                    QuestionType.FREE_TEXT
            ),

            new Question(
                    UUID.fromString("02E8D87E-6FD7-48CD-8AD1-BA3E179B86B7"),
                    "In welcher Stadt befindet sich die Goldelse?",
                    new String[]{"Berlin"},
                    new String[]{"Berlin"},
                    QuestionType.FREE_TEXT
            ),

            new Question(
                    UUID.fromString("27A338F3-8294-4ACD-957C-C8F9D170EDD3"),
                    "Wie heißt die eSport News App von Upday?",
                    new String[]{"Jaxon"},
                    new String[]{"Jaxon"},
                    QuestionType.FREE_TEXT
            ),

            new Question(
                    UUID.fromString("BE20C2D0-2386-4B10-BECF-0E627385C244"),
                    "In welchem jahr entstand der Axel Springer Neubau?",
                    new String[]{"2020"},
                    new String[]{"2020"},
                    QuestionType.FREE_TEXT
            ),

            new Question(
                    UUID.fromString("6D3895BA-2979-4919-AF44-11171539A456"),
                    "Wie lautet die Antwort von dem Supercomputer Deep Thought?",
                    new String[]{"42"},
                    new String[]{"42"},
                    QuestionType.FREE_TEXT
            ),

            new Question(
                    UUID.fromString("AEAA020A-70BC-4551-8E46-8FE1D3D05346"),
                    "Wie lautet die Dezimalzahl 42 in Binär?",
                    new String[]{"101010"},
                    new String[]{"101010"},
                    QuestionType.FREE_TEXT
            ),

            new Question(
                    UUID.fromString("5F213BB3-AB3C-4BB3-86C9-25C410D84CB7"),
                    "Wie lautet die Dezimalzahl 42 in Hexadezimal?",
                    new String[]{"2A"},
                    new String[]{"2A"},
                    QuestionType.FREE_TEXT
            ),

            new Question(
                    UUID.fromString("1D4B9E02-3B39-4B93-B835-EDBB10D97426"),
                    "Wie lautet die Dezimalzahl 42 in Oktal?",
                    new String[]{"52"},
                    new String[]{"52"},
                    QuestionType.FREE_TEXT
            ),

            new Question(
                    UUID.fromString("5A6B898C-6F94-4A12-9809-6C54C10C632A"),
                    "Schreib Freund und tritt ein",
                    new String[]{"Freund"},
                    new String[]{"Freund"},
                    QuestionType.FREE_TEXT
            )

    );

}


package org.example.quizleapi.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleChoice {

    public static final List<Question> SINGLE_CHOICE_QUESTIONS = Arrays.asList(
            new Question(
                    "Wie schreibt man",
                    new String[]{"Portemonnaie",
                            "Portmonnaie",
                            "Portemonaie"},
                    new String[]{"Portemonnaie"},
                    QuestionType.SINGLE_CHOICE
            ),

            new Question("Sich über eine ... aufregen.",
                    new String[]{"Lapallie",
                            "Lapalie",
                            "Lappalie"},
                    new String[]{"Lappalie"},
                    QuestionType.SINGLE_CHOICE
            ),

            new Question("Die Lösung war",
                    new String[]{"dillettantisch",
                            "dilletantisch",
                            "dilettantisch"},
                    new String[]{"dilettantisch"},
                    QuestionType.SINGLE_CHOICE
            ),

            new Question("Andere Bedeutung für ohne geldliche Gegenleistung",
                    new String[]{"unentgeltlich",
                            "unentgeldlich",
                            "unendgeltlich"},
                    new String[]{"unentgeltlich"},
                    QuestionType.SINGLE_CHOICE
            ),

            new Question("ASIdeas haben ein sehr gutes",
                    new String[]{"Renomee",
                            "Renommee",
                            "Renomme"},
                    new String[]{"Renommee"},
                    QuestionType.SINGLE_CHOICE
            ),

            new Question("Wie hieß Ryan früher mal?",
                    new String[]{"Le Linh Tung",
                            "Le Chinh Tuan",
                            "Le Duc Anh"},
                    new String[]{"Le Duc Anh"},
                    QuestionType.SINGLE_CHOICE
            ),

            new Question("Welches Land hat die drittgrößte Fläche?",
                    new String[]{"Vereinigten Staaten von Amerika",
                            "Brasilien",
                            "China"},
                    new String[]{"Vereinigten Staaten von Amerika"},
                    QuestionType.SINGLE_CHOICE
            ),

            new Question("Welche Kaffeeart hat den höchsten Koffeinanteil?",
                    new String[]{"Arabica",
                            "Robusta",
                            "Liberica"},
                    new String[]{"Liberica"},
                    QuestionType.SINGLE_CHOICE
            ),

            new Question("Welchen Passierschein benötigen Asterix & Obelix?",
                    new String[]{"A38",
                            "M38",
                            "L38"},
                    new String[]{"A38"},
                    QuestionType.SINGLE_CHOICE
            ),

            new Question("Wie lautet der Spitzname für Absinth?",
                    new String[]{"die grüne Fee",
                            "der grüne Kobold",
                            "der grüne Zwerg"},
                    new String[]{"die grüne Fee"},
                    QuestionType.SINGLE_CHOICE
            ),

            new Question("Welchen Passierschein benötigen Asterix & Obelix?",
                    new String[]{"A38",
                            "M38",
                            "L38"},
                    new String[]{"A38"},
                    QuestionType.SINGLE_CHOICE
            )

    );

}

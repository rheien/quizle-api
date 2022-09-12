package org.example.quizleapi.questions;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class SingleChoice {

    public static final List<Question> SINGLE_CHOICE_QUESTIONS = Arrays.asList(
            new Question(
                    UUID.fromString("2D7CDAD4-A3D0-41A9-BCE7-DF6F74D92777"),
                    "Wie schreibt man",
                    new String[]{"Portemonnaie",
                            "Portmonnaie",
                            "Portemonaie"},
                    new String[]{"Portemonnaie"},
                    QuestionType.SINGLE_CHOICE
            ),

            new Question(
                    UUID.fromString("091052D0-F0A8-48BC-A3FE-39259D313844"),
                    "Sich über eine ... aufregen.",
                    new String[]{"Lapallie",
                            "Lapalie",
                            "Lappalie"},
                    new String[]{"Lappalie"},
                    QuestionType.SINGLE_CHOICE
            ),

            new Question(
                    UUID.fromString("2B12CC79-5088-44C3-A3B7-1515C722A498"),
                    "Die Lösung war",
                    new String[]{"dillettantisch",
                            "dilletantisch",
                            "dilettantisch"},
                    new String[]{"dilettantisch"},
                    QuestionType.SINGLE_CHOICE
            ),

            new Question(
                    UUID.fromString("0B874377-C498-4600-BB16-4CD9BEC9CE39"),
                    "Andere Bedeutung für ohne geldliche Gegenleistung",
                    new String[]{"unentgeltlich",
                            "unentgeldlich",
                            "unendgeltlich"},
                    new String[]{"unentgeltlich"},
                    QuestionType.SINGLE_CHOICE
            ),

            new Question(
                    UUID.fromString("E020E9F3-DE85-42A1-A6CB-3D2B25AE7EB3"),
                    "ASIdeas haben ein sehr gutes",
                    new String[]{"Renomee",
                            "Renommee",
                            "Renomme"},
                    new String[]{"Renommee"},
                    QuestionType.SINGLE_CHOICE
            ),

            new Question(
                    UUID.fromString("90B0AC69-44B2-43C2-A2E2-75BB6DEB5B97"),
                    "Wie hieß Ryan früher mal?",
                    new String[]{"Le Linh Tung",
                            "Le Chinh Tuan",
                            "Le Duc Anh"},
                    new String[]{"Le Duc Anh"},
                    QuestionType.SINGLE_CHOICE
            ),

            new Question(
                    UUID.fromString("868F4F9F-FF60-4618-87F5-C9D12BB74618"),
                    "Welches Land hat die drittgrößte Fläche?",
                    new String[]{"Vereinigten Staaten von Amerika",
                            "Brasilien",
                            "China"},
                    new String[]{"Vereinigten Staaten von Amerika"},
                    QuestionType.SINGLE_CHOICE
            ),

            new Question(
                    UUID.fromString("16F326EA-6A4C-42E9-B8BE-BD2F15798A96"),
                    "Welche Kaffeeart hat den höchsten Koffeinanteil?",
                    new String[]{"Arabica",
                            "Robusta",
                            "Liberica"},
                    new String[]{"Liberica"},
                    QuestionType.SINGLE_CHOICE
            ),

            new Question(
                    UUID.fromString("2E1E1E40-E303-404C-A264-85DAD9978E63"),
                    "Welchen Passierschein benötigen Asterix & Obelix?",
                    new String[]{"A38",
                            "M38",
                            "L38"},
                    new String[]{"A38"},
                    QuestionType.SINGLE_CHOICE
            ),

            new Question(
                    UUID.fromString("6E929121-2D23-4A9B-8581-417D564E91BC"),
                    "Wie lautet der Spitzname für Absinth?",
                    new String[]{"die grüne Fee",
                            "der grüne Kobold",
                            "der grüne Zwerg"},
                    new String[]{"die grüne Fee"},
                    QuestionType.SINGLE_CHOICE
            ),

            new Question(
                    UUID.fromString("2AA768BA-0FBC-4EA4-B5EB-F3FAA5D1CCE4"),
                    "Welchen Passierschein benötigen Asterix & Obelix?",
                    new String[]{"A38",
                            "M38",
                            "L38"},
                    new String[]{"A38"},
                    QuestionType.SINGLE_CHOICE
            )

    );

}

package org.example.quizleapi.questions;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class MultipleChoice {

    public static final List<Question> MULTIPLE_CHOICE_QUESTIONS = Arrays.asList(
            new Question(
                    UUID.fromString("DAF33C83-C546-47BA-9112-87DE0FD4A7BC"),
                    "Pi = 3,1415...",
                    new String[]{"92",
                            "93",
                            "94",
                            "95"},
                    new String[]{"92"},
                    QuestionType.MULTIPLE_CHOICE
            ),

            new Question(
                    UUID.fromString("AB47EBD7-8F8D-4567-8FBC-3546C3BFCBD9"),
                    "Welche Automarken gehören nicht zu Volkswagen?",
                    new String[]{"SKODA", "OPEL", "PORSCHE", "FIAT"},
                    new String[]{"OPEL", "FIAT"},
                    QuestionType.MULTIPLE_CHOICE
            ),

            new Question(
                    UUID.fromString("F1029942-4E57-4269-95A7-1EAE546AE555"),
                    "Wo befindet sich Ei als Zusatzstoff?",
                    new String[]{"Bier", "Nougat", "Panaden", "Weizenbrot"},
                    new String[]{"Bier", "Nougat", "Panaden"},
                    QuestionType.MULTIPLE_CHOICE
            ),

            new Question(
                    UUID.fromString("C1530224-6099-4A7D-AE2B-0C54310C11DF"),
                    "Was meint der Berliner mit 'Dit ist mir Wurscht wie Stulle!' nicht?",
                    new String[]{"Das ist meine Wurst mit Stulle!",
                            "Es ist Wurst mit Stulle",
                            "Es ist mir egal!",
                            "Wir müssen Wurst wie Stulle kaufen!"},
                    new String[]{"Das ist meine Wurst mit Stulle!",
                            "Es ist Wurst mit Stulle",
                            "Wir müssen Wurst wie Stulle kaufen!"},
                    QuestionType.MULTIPLE_CHOICE
            ),

            new Question(
                    UUID.fromString("84A49F5F-46E6-41E9-9A1E-9C33DEB90AC7"),
                    "Was versteht man in Sachsen unter 'Bemme'?",
                    new String[]{"sich beeilen",
                            "Belegte Brotscheibe",
                            "eine Beule im Auto",
                            "Stulle"},
                    new String[]{"Belegte Brotscheibe",
                            "Stulle"},
                    QuestionType.MULTIPLE_CHOICE
            ),

            new Question(
                    UUID.fromString("52AB9662-767F-4705-93FF-B1EEDBF3299D"),
                    "Wie lauten die Spitznamen von Ryan?",
                    new String[]{"Reiner",
                            "Ryani",
                            "Le Rien",
                            "Rhein"},
                    new String[]{"Reiner",
                            "Ryani",
                            "Le Rien",
                            "Rhein"},
                    QuestionType.MULTIPLE_CHOICE
            ),

            new Question(
                    UUID.fromString("15F2CBD2-D763-4AB7-B7B5-D4D85FF3430D"),
                    "Wo wird die Schreibweise 'Whisky' genutzt?",
                    new String[]{"USA",
                            "Kanada",
                            "Schottland",
                            "Irland"},
                    new String[]{"USA",
                            "Kanada",
                            "Schottland"},
                    QuestionType.MULTIPLE_CHOICE
            ),

            new Question(
                    UUID.fromString("97D055C6-7572-429D-8EE6-C4800350B121"),
                    "Wo wird die Schreibweise 'Whiskey' genutzt?",
                    new String[]{"USA",
                            "Kanada",
                            "Schottland",
                            "Irland"},
                    new String[]{"USA",
                            "Irland"},
                    QuestionType.MULTIPLE_CHOICE
            )
    );

}

package org.example.quizleapi.questions;

import java.util.Arrays;
import java.util.List;

public class MultipleChoice {

    public static final List<Question> MULTIPLE_CHOICE_QUESTIONS = Arrays.asList(
            new Question(
                    "Pi = 3,1415...",
                    new String[]{"92",
                            "93",
                            "94",
                            "95"},
                    new String[]{"92"},
                    QuestionType.MULTIPLE_CHOICE
            ),

            new Question("Welche Automarken gehören nicht zu Volkswagen?",
                    new String[]{"SKODA", "OPEL", "PORSCHE", "FIAT"},
                    new String[]{"OPEL", "FIAT"},
                    QuestionType.MULTIPLE_CHOICE
            ),

            new Question("Wo befindet sich Ei als Zusatzstoff?",
                    new String[]{"Bier", "Nougat", "Panaden", "Weizenbrot"},
                    new String[]{"Bier", "Nougat", "Panaden"},
                    QuestionType.MULTIPLE_CHOICE
            ),

            new Question("Was meint der Berliner mit 'Dit ist mir Wurscht wie Stulle!' nicht?",
                    new String[]{"Das ist meine Wurst mit Stulle!",
                            "Es ist Wurst mit Stulle",
                            "Es ist mir egal!",
                            "Wir müssen Wurst wie Stulle kaufen!"},
                    new String[]{"Das ist meine Wurst mit Stulle!",
                            "Es ist Wurst mit Stulle",
                            "Wir müssen Wurst wie Stulle kaufen!"},
                    QuestionType.MULTIPLE_CHOICE
            ),

            new Question("Was versteht man in Sachsen unter 'Bemme'?",
                    new String[]{"sich beeilen",
                            "Belegte Brotscheibe",
                            "eine Beule im Auto",
                            "Stulle"},
                    new String[]{"Belegte Brotscheibe",
                            "Stulle"},
                    QuestionType.MULTIPLE_CHOICE
            ),

            new Question("Wie lauten die Spitznamen von Ryan?",
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

            new Question("Wo wird die Schreibweise 'Whisky' genutzt?",
                    new String[]{"USA",
                            "Kanada",
                            "Schottland",
                            "Irland"},
                    new String[]{"USA",
                            "Kanada",
                            "Schottland"},
                    QuestionType.MULTIPLE_CHOICE
            ),

            new Question("Wo wird die Schreibweise 'Whiskey' genutzt?",
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

package org.example.quizleapi.questions;

import java.util.HashMap;
import java.util.Map;

public class singleChoice {
    public static Map<String, Map<QuestionType, Map<String, Boolean>>> getSingleChoices() {
        HashMap<String, Map<QuestionType, Map<String, Boolean>>> questions = new HashMap<>();

        HashMap<QuestionType, Map<String, Boolean>> type = new HashMap<>();
        HashMap<String, Boolean> answer1 = new HashMap<>();
        answer1.put("Portemonnaie", true);
        answer1.put("Portmonnaie", false);
        answer1.put("Portemonaie", false);
        type.put(QuestionType.SINGLE_CHOICE, answer1);
        questions.put("Wie schreibt man", type);

        HashMap<String, Boolean> answer2 = new HashMap<>();
        answer2.put("Lappalie", true);
        answer2.put("Lapalie", false);
        answer2.put("Lapallie", false);
        type.put(QuestionType.SINGLE_CHOICE, answer2);
        questions.put("Sich über eine ... aufregen.", type);


        return questions;
    }
}

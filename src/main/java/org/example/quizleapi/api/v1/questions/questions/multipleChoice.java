package org.example.quizleapi.api.v1.questions.questions;

import org.example.quizleapi.api.v1.questions.game.QuestionType;

import java.util.HashMap;
import java.util.Map;

class multipleChoice {

    public static Map<String, Map<QuestionType, Map<String, Boolean>>> getMultipleChoices() {
        HashMap<String, Map<QuestionType, Map<String, Boolean>>> questions = new HashMap<>();

        HashMap<QuestionType, Map<String, Boolean>> type = new HashMap<>();
        HashMap<String, Boolean> answer1 = new HashMap<>();
        answer1.put("92", true);
        answer1.put("93", false);
        answer1.put("94", false);
        answer1.put("95", false);
        type.put(QuestionType.MULTIPLE_CHOICE, answer1);
        questions.put("Pi = 3,1415...", type);

        HashMap<String, Boolean> answer2 = new HashMap<>();
        answer2.put("OPEL", true);
        answer2.put("SKODA", false);
        answer2.put("PORSCHE", false);
        answer2.put("FIAT", true);
        type.put(QuestionType.MULTIPLE_CHOICE, answer2);
        questions.put("Welche Automarken gehören nicht zu Volkswagen?", type);


        return questions;
    }

}

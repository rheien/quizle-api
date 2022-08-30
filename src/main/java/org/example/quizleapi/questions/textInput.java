package org.example.quizleapi.questions;

import java.util.HashMap;
import java.util.Map;

public class textInput {

    public static Map<String, Map<QuestionType, Map<String, Boolean>>> getTextInput() {
        HashMap<String, Map<QuestionType, Map<String, Boolean>>> questions = new HashMap<>();

        HashMap<QuestionType, Map<String, Boolean>> type = new HashMap<>();
        HashMap<String, Boolean> answer1 = new HashMap<>();
        answer1.put("Sommerrolle", true);
        type.put(QuestionType.FREE_TEXT, answer1);
        questions.put("Wie heißt die nicht frittierte Variante von der Frühlingsrolle?", type);

        HashMap<String, Boolean> answer2 = new HashMap<>();
        answer2.put("Basketball", true);
        type.put(QuestionType.FREE_TEXT, answer2);
        questions.put("In welcher Sportart nutzt man den 'Fadeaway'?", type);


        return questions;
    }
}


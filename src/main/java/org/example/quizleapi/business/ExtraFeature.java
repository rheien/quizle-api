package org.example.quizleapi.business;

public class ExtraFeature {
    public static int randomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static String[] shuffleArray(String[] answers) {
        for (int i = 0; i < answers.length; i++) {
            int j = randomNumber(0, answers.length - 1);

            String temp = answers[i];
            answers[i] = answers[j];
            answers[j] = temp;
        }

        return answers;
    }
}

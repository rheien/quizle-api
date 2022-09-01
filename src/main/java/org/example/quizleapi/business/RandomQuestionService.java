package org.example.quizleapi.business;

import org.example.quizleapi.questions.MultipleChoice;
import org.example.quizleapi.questions.Question;
import org.example.quizleapi.questions.SingleChoice;
import org.example.quizleapi.questions.TextInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomQuestionService implements QuestionService {

    static final int QUESTIONS_PER_SET = 6;
    static final int QUESTIONS_PER_TYPE = 2;

    @Override
    public List<Question> assembleQuestions(int numberOfQuestions, String[] excludedQuestions) {
        List<Question> assembledQuestions = new ArrayList<>();

        MultipleChoice mCQuestions = new MultipleChoice();
        List<Question> mChoice = mCQuestions.MULTIPLE_CHOICE_QUESTIONS;
        assembledQuestions.addAll(poseQuestions(mChoice, excludedQuestions));

        SingleChoice sCQuestions = new SingleChoice();
        List<Question> sChoice = sCQuestions.SINGLE_CHOICE_QUESTIONS;
        assembledQuestions.addAll(poseQuestions(sChoice, excludedQuestions));

        TextInput tIQuestions = new TextInput();
        List<Question> freeText = tIQuestions.FREE_TEXT_QUESTIONS;
        assembledQuestions.addAll(poseQuestions(freeText, excludedQuestions));

        return assembledQuestions;
    }

    public List<Question> poseQuestions(List<Question> questions, String[] excludedQuestions) {
        List<Question> assembleQuestions = new ArrayList<Question>();

        for (int i = 0; i < QUESTIONS_PER_TYPE; i++) {
            int index = Util.getRandomNumber(questions.size());

            while (hasBeenPicked(assembleQuestions, questions.get(index)) || shouldBeExcluded(questions.get(index), excludedQuestions)) {
                index = Util.getRandomNumber(questions.size());
            }

            Question question = questions.get(index);

            assembleQuestions.add(question);
        }

        return assembleQuestions;
    }

    public boolean hasBeenPicked(List<Question> pickedQuestions, Question newPickQuestion) {
        return pickedQuestions.contains(newPickQuestion);
    }

    public boolean shouldBeExcluded(Question question, String[] excludedQuestions) {
        if (excludedQuestions.length == 0) return false;

        return 0 < Arrays.binarySearch(excludedQuestions, question.question);
    }
}

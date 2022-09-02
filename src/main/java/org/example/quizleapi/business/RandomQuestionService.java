package org.example.quizleapi.business;

import org.eclipse.jetty.util.IO;
import org.example.quizleapi.questions.MultipleChoice;
import org.example.quizleapi.questions.Question;
import org.example.quizleapi.questions.SingleChoice;
import org.example.quizleapi.questions.TextInput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomQuestionService implements QuestionService {

    //TODO: how to change so that at least one of each type is been picked
    static final int QUESTIONS_PER_TYPE = 2;

    @Override
    public List<Question> assembleQuestions(int numberOfQuestions, String[] excludedQuestions) {
        List<Question> assembledQuestions = new ArrayList<>();

        if (excludedQuestions == null) return assembledQuestions;


        //TODO: refactor to seperate class
        List<Question> mChoice = MultipleChoice.MULTIPLE_CHOICE_QUESTIONS;
        if (!enoughQuestionsLeft(mChoice, excludedQuestions)) {
            return new ArrayList<Question>();
        }
        assembledQuestions.addAll(poseQuestions(mChoice, excludedQuestions));

        List<Question> sChoice = SingleChoice.SINGLE_CHOICE_QUESTIONS;
        if (!enoughQuestionsLeft(sChoice, excludedQuestions)) {
            return new ArrayList<Question>();
        }
        assembledQuestions.addAll(poseQuestions(sChoice, excludedQuestions));

        List<Question> freeText = TextInput.FREE_TEXT_QUESTIONS;
        if (!enoughQuestionsLeft(freeText, excludedQuestions)) {
            return new ArrayList<Question>();
        }
        assembledQuestions.addAll(poseQuestions(freeText, excludedQuestions));

        return assembledQuestions;
    }

    public boolean validNumber(int numberOfQuestions) throws IOException {
        if (numberOfQuestions < 0) {
            throw new IOException("Invalid number");
        } else if (numberOfQuestions > (TextInput.FREE_TEXT_QUESTIONS.size() +
                SingleChoice.SINGLE_CHOICE_QUESTIONS.size() +
                MultipleChoice.MULTIPLE_CHOICE_QUESTIONS.size())) {
            throw new IOException("So many questions aren't available");
        }
        return numberOfQuestions > 0;
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

    public boolean enoughQuestionsLeft(List<Question> questions, String[] excludedQuestions) {
        if (excludedQuestions.length == 0) return true;

        List<Question> checkedQuestions = new ArrayList<Question>();
        for (Question question : questions) {

            for (String exclQuestion : excludedQuestions) {
                if (exclQuestion.equals(question.question)) {
                    checkedQuestions.add(question);
                }
            }
        }
        return checkedQuestions.size() >= QUESTIONS_PER_TYPE;
    }
}

package org.example.quizleapi.business;

import org.example.quizleapi.questions.MultipleChoice;
import org.example.quizleapi.questions.Question;
import org.example.quizleapi.questions.SingleChoice;
import org.example.quizleapi.questions.TextInput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class RandomQuestionService implements QuestionService {

    //TODO: how to change so that at least one of each type is been picked?
    static final int QUESTIONS_PER_TYPE = 2;

    public List<Question> assembleQuestions(int numberOfQuestions, UUID[] excludedIDs) {
        List<Question> assembledQuestions = new ArrayList<>();

        if (excludedIDs == null) return assembledQuestions;


        //TODO: refactor to seperate class
        List<Question> mChoice = MultipleChoice.MULTIPLE_CHOICE_QUESTIONS;
        if (!enoughQuestionsLeft(mChoice, excludedIDs)) {
            return new ArrayList<Question>();
        }
        assembledQuestions.addAll(poseQuestions(mChoice, excludedIDs));

        List<Question> sChoice = SingleChoice.SINGLE_CHOICE_QUESTIONS;
        if (!enoughQuestionsLeft(sChoice, excludedIDs)) {
            return new ArrayList<Question>();
        }
        assembledQuestions.addAll(poseQuestions(sChoice, excludedIDs));

        List<Question> freeText = TextInput.FREE_TEXT_QUESTIONS;
        if (!enoughQuestionsLeft(freeText, excludedIDs)) {
            return new ArrayList<Question>();
        }
        assembledQuestions.addAll(poseQuestions(freeText, excludedIDs));

        return assembledQuestions;
    }

    public void validNumber(int numberOfQuestions) throws IOException {
        if (numberOfQuestions < 0) {
            throw new IOException("Invalid number");
        } else if (numberOfQuestions > (TextInput.FREE_TEXT_QUESTIONS.size() +
                SingleChoice.SINGLE_CHOICE_QUESTIONS.size() +
                MultipleChoice.MULTIPLE_CHOICE_QUESTIONS.size())) {
            throw new IOException("So many questions aren't available");
        }
    }

    public List<Question> poseQuestions(List<Question> questions, UUID[] excludedIDs) {
        List<Question> assembleQuestions = new ArrayList<Question>();

        for (int i = 0; i < QUESTIONS_PER_TYPE; i++) {
            int index = Util.getRandomNumber(questions.size());

            while (hasBeenPicked(assembleQuestions, questions.get(index).id) ||
                    shouldBeExcluded(excludedIDs, questions.get(index).id)) {
                index = Util.getRandomNumber(questions.size());
            }
            Question question = questions.get(index);
            assembleQuestions.add(question);
        }
        return assembleQuestions;
    }

    public boolean hasBeenPicked(List<Question> pickedQuestions, UUID id) {
        for (Question question : pickedQuestions) {
            if(question.id.equals(id)) return true;
        }
        return false;

        //return pickedQuestions.equals(id);
    }

    public boolean shouldBeExcluded(UUID[] excludedIDs, UUID id) {
        for (UUID excludedID : excludedIDs) {
            if(excludedID.equals(id)) return true;
        }
        return false;
    }

    public boolean enoughQuestionsLeft(List<Question> questions, UUID[] excludedIDs) {
        if (excludedIDs.length == 0) return true;

        List<Question> checkedQuestions = new ArrayList<Question>();
        for (Question question : questions) {

            for (UUID exclQuestion : excludedIDs) {
                if (exclQuestion.equals(question.id)) {
                    checkedQuestions.add(question);
                }
            }
        }
        return checkedQuestions.size() >= QUESTIONS_PER_TYPE;
    }
}

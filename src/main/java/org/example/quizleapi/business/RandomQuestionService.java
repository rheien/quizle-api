package org.example.quizleapi.business;

import org.example.quizleapi.questions.MultipleChoice;
import org.example.quizleapi.questions.Question;
import org.example.quizleapi.questions.SingleChoice;
import org.example.quizleapi.questions.TextInput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.example.quizleapi.questions.TextInput.FREE_TEXT_QUESTIONS;

public class RandomQuestionService implements QuestionService {

    //TODO: how to change so that at least one of each type is been picked?
    static final int QUESTIONS_PER_TYPE = 1;//2;

    public List<Question> assembleQuestions(int numberOfQuestions, UUID[] excludedIDs) throws IOException {
        validNumber(numberOfQuestions);

        if (excludedIDs == null) return new ArrayList<>();

        List<List<Question>> questions = new ArrayList<List<Question>>();
        questions.add(TextInput.FREE_TEXT_QUESTIONS);
        questions.add(SingleChoice.SINGLE_CHOICE_QUESTIONS);
        questions.add(MultipleChoice.MULTIPLE_CHOICE_QUESTIONS);

        return getQuestionList(questions, numberOfQuestions, excludedIDs);
    }

    public List<Question> getQuestionList(List<List<Question>> questions, int numberOfQuestions, UUID[] excludedIDs) {

        List<Question> assembledQuestions = new ArrayList<>();
        while (numberOfQuestions > 0) {
            int randomNumber = Util.getRandomNumber(questions.size());
            if (!enoughQuestionsLeft(questions.get(randomNumber), excludedIDs)) {
                return new ArrayList<Question>();
            }
            assembledQuestions.addAll(poseQuestions(assembledQuestions, questions.get(randomNumber), excludedIDs));
            numberOfQuestions--;
        }
        return assembledQuestions;
    }

    public void validNumber(int numberOfQuestions) throws IOException {
        if (numberOfQuestions < 0) {
            throw new IOException("Invalid number");
        } else if (numberOfQuestions > (FREE_TEXT_QUESTIONS.size() +
                SingleChoice.SINGLE_CHOICE_QUESTIONS.size() +
                MultipleChoice.MULTIPLE_CHOICE_QUESTIONS.size())) {
            throw new IOException("So many questions aren't available");
        }
    }

    public List<Question> poseQuestions(List<Question> assembleQuestions, List<Question> questions, UUID[] excludedIDs) {
        List<Question> pickQuestions = new ArrayList<Question>();

        int index = Util.getRandomNumber(questions.size());

        while (hasBeenPicked(assembleQuestions, questions.get(index).id) ||
                shouldBeExcluded(excludedIDs, questions.get(index).id)) {
            index = Util.getRandomNumber(questions.size());
        }
        Question question = questions.get(index);
        pickQuestions.add(question);

        return pickQuestions;
    }

    public boolean hasBeenPicked(List<Question> pickedQuestions, UUID id) {
        boolean isPicked = false;
        for (Question question : pickedQuestions) {
            if (question.id.equals(id)) {
                isPicked = true;
                break;
            }
        }
        return isPicked;
    }

    public boolean shouldBeExcluded(UUID[] excludedIDs, UUID id) {
        for (UUID excludedID : excludedIDs) {
            boolean isExcluded = excludedID.equals(id);
            if (isExcluded) {
                return true;
            }
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
        return questions.size() > checkedQuestions.size();
    }
}

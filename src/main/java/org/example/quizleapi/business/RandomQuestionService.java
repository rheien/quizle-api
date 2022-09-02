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

    //TODO: return something better than an empty list
    /*
    public List<Question> questionAssembler(List<Question> questions, String[] excludedQuestions) {
        if (!enoughQuestionsLeft(questions, excludedQuestions)) {
            return new ArrayList<Question>();
        }
        return poseQuestions(questions, excludedQuestions);
    }
    */


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

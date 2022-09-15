package org.example.quizleapi.business;

import org.example.quizleapi.questions.MultipleChoice;
import org.example.quizleapi.questions.Question;
import org.example.quizleapi.questions.SingleChoice;
import org.example.quizleapi.questions.TextInput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RandomQuestionService implements QuestionService {

    public List<Question> assembleQuestions(int numberOfQuestions, List<UUID> excludedIDs) throws IOException {
        List<List<Question>> questions = new ArrayList<List<Question>>();
        questions.add(TextInput.FREE_TEXT_QUESTIONS);
        questions.add(SingleChoice.SINGLE_CHOICE_QUESTIONS);
        questions.add(MultipleChoice.MULTIPLE_CHOICE_QUESTIONS);

        validNumber(numberOfQuestions, questions);

        if (excludedIDs == null) return new ArrayList<>();

        return getQuestionList(questions, numberOfQuestions, excludedIDs);
    }

    /**
     * This method assemble random questions from random type of answers.
     *
     * @param questions         a question list of all questions
     * @param numberOfQuestions a number that determines how big the question list will be
     * @param excludedIDs       a list which must not be used again
     * @return a list of valid questions for the quiz
     */
    public List<Question> getQuestionList(List<List<Question>> questions, int numberOfQuestions, List<UUID> excludedIDs) {
        List<Question> assembledQuestions = new ArrayList<>();

        //it should pick one question of each type of answers
        int numberOfTypesOfAnswers = questions.size();
        for (int index = 0; index < numberOfTypesOfAnswers; index++) {
            if (!enoughQuestionsLeft(questions.get(index), excludedIDs)) {
                return new ArrayList<Question>();
            }
            assembledQuestions.addAll(poseQuestions(assembledQuestions, questions.get(index), excludedIDs));
        }

        //the rest of questions will be picked randomly
        while (numberOfQuestions > assembledQuestions.size()) {
            int randomNumber = randomNumber(0, questions.size());
            if (!enoughQuestionsLeft(questions.get(randomNumber), excludedIDs)) {
                return new ArrayList<Question>();
            }
            assembledQuestions.addAll(poseQuestions(assembledQuestions, questions.get(randomNumber), excludedIDs));
        }
        return assembledQuestions;
    }

    /**
     * This method checks the invalid input when it's less than 0 or greater than the question collection.
     *
     * @param numberOfQuestions a number for the questions to be passed
     * @throws IOException if the number is less than 0 it should throw an "invalid number" and
     *                     is it greater than the collection it should throw a message that there are no
     *                     more questions available.
     */
    public void validNumber(int numberOfQuestions, List<List<Question>> questions) throws IOException {
        int totalNumberOfQuestions = 0;
        for (List<Question> question : questions) {
             totalNumberOfQuestions += question.size();
        }

        int typesOfAnswers = questions.size();

        if (numberOfQuestions > totalNumberOfQuestions) {
            throw new IOException("So many questions aren't available");
        } else if (numberOfQuestions < typesOfAnswers){
            throw new IOException("Invalid Input. The number must be at least this high: "+typesOfAnswers+".");
        }

    }

    /**
     * This method pick one valid question for the quiz
     *
     * @param assembleQuestions a list of assembled questions for the quiz
     * @param questions         a list of questions from one type of answers
     * @param excludedIDs       a list which must not be used again
     * @return one question in a list of questions
     */
    public List<Question> poseQuestions(List<Question> assembleQuestions, List<Question> questions, List<UUID> excludedIDs) {
        List<Question> pickQuestions = new ArrayList<Question>();

        int index = randomNumber(0, questions.size());

        while (hasBeenPicked(assembleQuestions, questions.get(index).id) ||
                shouldBeExcluded(excludedIDs, questions.get(index).id)) {
            index = randomNumber(0, questions.size());
        }
        Question question = questions.get(index);
        pickQuestions.add(question);

        return pickQuestions;
    }

    /**
     * This method checks for duplicate questions
     *
     * @param pickedQuestions a list for the quiz
     * @param id              given UUID to check
     * @return true if question is duplicated
     */
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

    /**
     * This method checks if the questions are in the given UUID list
     *
     * @param excludedIDs a UUID list which must not be used again
     * @param id          given UUID to check
     * @return true if the questions are in the given UUID list
     */
    public boolean shouldBeExcluded(List<UUID> excludedIDs, UUID id) {
        for (UUID excludedID : excludedIDs) {
            boolean isExcluded = excludedID.equals(id);
            if (isExcluded) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks if any questions are available
     *
     * @param questions   a complete list of questions of one type of answers
     * @param excludedIDs a UUID list which must not be used again
     * @return true if at least one question is available
     */
    public boolean enoughQuestionsLeft(List<Question> questions, List<UUID> excludedIDs) {
        if (excludedIDs.isEmpty()) return true;

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

    public static int randomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}

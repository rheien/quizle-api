package org.example.quizleapi.business;

import org.example.quizleapi.questions.MultipleChoice;
import org.example.quizleapi.questions.Question;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.example.quizleapi.business.RandomQuestionService.QUESTIONS_PER_SET;
import static org.example.quizleapi.business.RandomQuestionService.QUESTIONS_PER_TYPE;
import static org.junit.jupiter.api.Assertions.*;

class RandomQuestionServiceTest {

    //simpler formulieren
    @Test
    public void withNumberOfQuestions_and_emptyBlacklist_it_should_return_aQuestionList() {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        int numberOfQuestions = QUESTIONS_PER_SET;
        String[] emptyQuestions = new String[]{};
        List<Question> actual = randomQuestionService.assembleQuestions(numberOfQuestions, emptyQuestions);

        assertTrue(numberOfQuestions == actual.size());
    }

    @Test
    public void withNumberOfQuestions_and_dependentOnTheBlacklist_it_should_return_aQuestionList() {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        int numberOfQuestions = QUESTIONS_PER_SET;
        String[] blacklist = new String[]{"Wie lautet der Vorname von Frau Springer?",
                "Wie heißt die nicht frittierte Variante von der Frühlingsrolle?",
                "Was meint der Berliner mit 'Dit ist mir Wurscht wie Stulle!' nicht?",
                "Pi = 3,1415...",
                "Wie schreibt man",
                "Sich über eine ... aufregen."
        };
        List<Question> actual = randomQuestionService.assembleQuestions(numberOfQuestions, blacklist);

        List<String> actualQuestions = new ArrayList<String>();
        for (Question question : actual) {
            actualQuestions.add(question.question);
        }
        ;

        //does this really check the elements of the lists?
        assertFalse(actualQuestions.containsAll(Arrays.asList(blacklist)));
    }

    @Test
    public void it_should_return_two_randomQuestionLists() {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        int numberOfQuestions = QUESTIONS_PER_SET;
        String[] emptyQuestions = new String[]{};
        List<Question> questionList1 = randomQuestionService.assembleQuestions(numberOfQuestions, emptyQuestions);
        List<Question> questionList2 = randomQuestionService.assembleQuestions(numberOfQuestions, emptyQuestions);

        assertNotEquals(questionList1, questionList2);
    }

    @Test
    public void it_should_return_noDuplicateQuestions() {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        int numberOfQuestions = QUESTIONS_PER_SET;
        String[] emptyQuestions = new String[]{};
        List<Question> actual = randomQuestionService.assembleQuestions(numberOfQuestions, emptyQuestions);
        Set<Question> uniqueQuestions = new HashSet<Question>(actual);

        assertEquals(actual.size(), uniqueQuestions.size());
    }

    //add test case for single choice or free text input?
    @Test
    public void poseQuestions_should_return_questionList_fromOneType() {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        int numberOfQuestions = QUESTIONS_PER_TYPE;
        String[] emptyQuestions = new String[]{};

        MultipleChoice mCQuestions = new MultipleChoice();
        List<Question> mChoice = mCQuestions.MULTIPLE_CHOICE_QUESTIONS;
        List<Question> actual = randomQuestionService.poseQuestions(mChoice,emptyQuestions);

        assertEquals(numberOfQuestions, actual.size());
    }

/*
    @Test
    public void () {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        int numberOfQuestions = 0;//QUESTIONS_PER_SET;
        String[] emptyQuestions = new String[]{};
        Question[] actual = randomQuestionService.assembleQuestions(numberOfQuestions, emptyQuestions);

        assertEquals(numberOfQuestions, actual.length);
    }

Util randomNumber = new Util();
        int numberOfQuestions = Util.getRandomNumber(QUESTIONS_PER_SET);

    */

}
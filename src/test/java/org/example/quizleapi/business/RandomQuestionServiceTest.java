package org.example.quizleapi.business;

import org.example.quizleapi.questions.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

import static org.example.quizleapi.business.RandomQuestionService.QUESTIONSET_PER_DEFAULT;
import static org.junit.jupiter.api.Assertions.*;

class RandomQuestionServiceTest {

    @Test
    public void assembleQuestions_should_return_aQuestionList() throws IOException {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        UUID[] emptyIDs = new UUID[]{};
        List<Question> actual = randomQuestionService.assembleQuestions(QUESTIONSET_PER_DEFAULT, emptyIDs);

        assertEquals(QUESTIONSET_PER_DEFAULT, actual.size());
    }

    @Test
    public void assembleQuestions_should_return_aQuestionList_withoutExcludedQuestions() throws IOException {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        UUID[] blacklist = new UUID[]{
                UUID.fromString("DAF33C83-C546-47BA-9112-87DE0FD4A7BC"),
                UUID.fromString("AB47EBD7-8F8D-4567-8FBC-3546C3BFCBD9"),
                UUID.fromString("2D7CDAD4-A3D0-41A9-BCE7-DF6F74D92777"),
                UUID.fromString("091052D0-F0A8-48BC-A3FE-39259D313844"),
                UUID.fromString("2FBA748A-C49A-40C0-B8FF-E0F8D32BD83D"),
                UUID.fromString("4CCC19A1-4227-4DE8-919F-4E0E1A8EB701")
        };

        List<Question> questions = randomQuestionService.assembleQuestions(QUESTIONSET_PER_DEFAULT, blacklist);
        List<UUID> ids = new ArrayList<>();
        for (Question question : questions) {
            ids.add(question.id);
        }
        UUID[] actual = ids.toArray(new UUID[ids.size()]);

        assertFalse(Arrays.deepEquals(actual, blacklist));
    }

    @Test
    public void assembleQuestions_should_return_twoRandomQuestionLists() throws IOException {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        int numberOfQuestions = QUESTIONSET_PER_DEFAULT;
        UUID[] emptyIDs = new UUID[]{};
        List<Question> questionList1 = randomQuestionService.assembleQuestions(numberOfQuestions, emptyIDs);
        List<Question> questionList2 = randomQuestionService.assembleQuestions(numberOfQuestions, emptyIDs);

        assertNotEquals(questionList1, questionList2);
    }

    @Test
    public void assembleQuestions_should_return_noDuplicateQuestions() throws IOException {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        UUID[] emptyIDs = new UUID[]{};
        List<Question> actual = randomQuestionService.assembleQuestions(QUESTIONSET_PER_DEFAULT, emptyIDs);
        Set<Question> uniqueQuestions = new HashSet<Question>(actual);

        assertEquals(actual.size(), uniqueQuestions.size());
    }

    //TODO: change or add test case for minimum available questions?
    @Test
    public void assembleQuestions_should_return_emptyList_noQuestionAvailable() throws IOException {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        List<Question> mChoiceQuestions = MultipleChoice.MULTIPLE_CHOICE_QUESTIONS;
        UUID[] entireListOfIDs = new UUID[mChoiceQuestions.size()];
        mChoiceQuestions.forEach((question) -> {
            entireListOfIDs[mChoiceQuestions.indexOf(question)] = question.id;
        });

        List<Question> actual = randomQuestionService.assembleQuestions(QUESTIONSET_PER_DEFAULT, entireListOfIDs);

        assertTrue(actual.isEmpty());
    }

    @Test
    public void assembleQuestions_should_return_emptyList_byNull() throws IOException {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        UUID[] nullIDs = null;
        List<Question> actual = randomQuestionService.assembleQuestions(QUESTIONSET_PER_DEFAULT, nullIDs);

        assertTrue(actual.isEmpty());
    }

    @Test
    public void enoughQuestionsLeft_should_return_true_forEnoughQuestionsLeft() {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        List<Question> questions = TextInput.FREE_TEXT_QUESTIONS;
        List<UUID> IDs = new ArrayList<UUID>();
        for (Question question : questions) {
            IDs.add(question.id);
        }
        UUID[] blacklist = IDs.subList(0, IDs.size() - 1)
                .toArray(new UUID[]{});

        boolean actual = randomQuestionService.enoughQuestionsLeft(questions, blacklist);

        assertTrue(actual);
    }

    @Test
    public void enoughQuestionsLeft_should_return_false_whenNotEnoughQuestionsLeft() {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        List<Question> questions = TextInput.FREE_TEXT_QUESTIONS;
        List<UUID> IDs = new ArrayList<UUID>();
        for (Question question : questions) {
            IDs.add(question.id);
        }
        UUID[] blacklist = IDs.subList(0, IDs.size())
                .toArray(new UUID[]{});

        boolean actual = randomQuestionService.enoughQuestionsLeft(questions, blacklist);

        assertFalse(actual);
    }

    @Test
    public void shouldBeExcluded_should_return_true_byEqualID() {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        UUID[] blacklist = new UUID[]{
                UUID.fromString("DAF33C83-C546-47BA-9112-87DE0FD4A7BC"),
                UUID.fromString("AB47EBD7-8F8D-4567-8FBC-3546C3BFCBD9")
        };

        UUID pickedSameID = UUID.fromString("DAF33C83-C546-47BA-9112-87DE0FD4A7BC");

        boolean actual = randomQuestionService.shouldBeExcluded(blacklist, pickedSameID);

        assertTrue(actual);
    }

    @Test
    public void shouldBeExcluded_should_return_false_byInvalidID() {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        UUID[] blacklist = new UUID[]{
                UUID.fromString("DAF33C83-C546-47BA-9112-87DE0FD4A7BC"),
                UUID.fromString("AB47EBD7-8F8D-4567-8FBC-3546C3BFCBD9")
        };

        UUID invalidID = UUID.randomUUID();

        boolean actual = randomQuestionService.shouldBeExcluded(blacklist, invalidID);

        assertFalse(actual);
    }

    @Test
    public void hasBeenPicked_should_return_true_byAlreadyPicked() {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        List<Question> pickedQuestions = Arrays.asList(
                new Question(
                        UUID.fromString("2FBA748A-C49A-40C0-B8FF-E0F8D32BD83D"),
                        "Wie lautet der Vorname von Frau Springer?",
                        new String[]{"Friede"},
                        new String[]{"Friede"},
                        QuestionType.FREE_TEXT
                ),

                new Question(
                        UUID.fromString("4CCC19A1-4227-4DE8-919F-4E0E1A8EB701"),
                        "Wie heißt die nicht frittierte Variante von der Frühlingsrolle?",
                        new String[]{"Sommerrolle"},
                        new String[]{"Sommerrolle"},
                        QuestionType.FREE_TEXT
                )
        );
        UUID pickedSameID = UUID.fromString("4CCC19A1-4227-4DE8-919F-4E0E1A8EB701");

        boolean actual = randomQuestionService.hasBeenPicked(pickedQuestions, pickedSameID);

        assertTrue(actual);
    }

    @Test
    public void poseQuestions_should_return_questionList_withoutBlacklist() {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        List<Question> questions = TextInput.FREE_TEXT_QUESTIONS;
        List<UUID> IDs = new ArrayList<UUID>();
        for (Question question : questions) {
            IDs.add(question.id);
        }
        UUID[] blacklist = IDs.subList(0, IDs.size() - 2)
                .toArray(new UUID[]{});

        List<Question> assembleQuestions = new ArrayList<Question>();

        List<Question> actual = randomQuestionService.poseQuestions(assembleQuestions, questions, blacklist);
        Set<Question> uniqueQuestions = new HashSet<Question>(actual);

        assertEquals(uniqueQuestions.size(), actual.size());
    }

    @Test
    public void poseQuestions_withBlacklist_should_return_questionList_withoutBlacklist() {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        UUID[] excludedIDs = new UUID[]{
                UUID.fromString("DAF33C83-C546-47BA-9112-87DE0FD4A7BC"),
                UUID.fromString("AB47EBD7-8F8D-4567-8FBC-3546C3BFCBD9")
        };

        List<Question> assembleQuestions = new ArrayList<Question>();
        List<Question> mChoiceQuestions = MultipleChoice.MULTIPLE_CHOICE_QUESTIONS;
        List<Question> actual = randomQuestionService.poseQuestions(assembleQuestions, mChoiceQuestions, excludedIDs);

        UUID[] actualIDs = new UUID[actual.size()];
        actual.forEach(question -> {
            actualIDs[actual.indexOf(question)] = question.id;
        });

        assertFalse(Arrays.deepEquals(excludedIDs, actualIDs));
    }
/*
    @Test
    public void getQuestionList_return_questionList_withChangedInput() {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        List<List<Question>> questions = new ArrayList<List<Question>>();
        questions.add(TextInput.FREE_TEXT_QUESTIONS);
        questions.add(SingleChoice.SINGLE_CHOICE_QUESTIONS);
        questions.add(MultipleChoice.MULTIPLE_CHOICE_QUESTIONS);

        int listSize = 0;
        for (List<Question> question : questions) {
            listSize += question.size();
        }
        int randomNumber = Util.getRandomNumber(QUESTIONSET_PER_DEFAULT, listSize);

        UUID[] emptyIDs = new UUID[]{};

        List<Question> actual = randomQuestionService.getQuestionList(questions, randomNumber, emptyIDs);

        assertEquals(randomNumber, actual.size());
    }

    @Test
    public void getQuestionList_return_questionList_withBlacklist() {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        List<List<Question>> questions = new ArrayList<List<Question>>();
        questions.add(TextInput.FREE_TEXT_QUESTIONS);
        questions.add(SingleChoice.SINGLE_CHOICE_QUESTIONS);
        questions.add(MultipleChoice.MULTIPLE_CHOICE_QUESTIONS);

        int listSize = 0;
        for (List<Question> question : questions) {
            listSize += question.size();
        }
        int randomNumber = Util.getRandomNumber(QUESTIONSET_PER_DEFAULT, listSize);

        UUID[] blacklist = new UUID[]{
                UUID.fromString("DAF33C83-C546-47BA-9112-87DE0FD4A7BC"),
                UUID.fromString("AB47EBD7-8F8D-4567-8FBC-3546C3BFCBD9"),
                UUID.fromString("2D7CDAD4-A3D0-41A9-BCE7-DF6F74D92777"),
                UUID.fromString("091052D0-F0A8-48BC-A3FE-39259D313844"),
                UUID.fromString("2FBA748A-C49A-40C0-B8FF-E0F8D32BD83D"),
                UUID.fromString("4CCC19A1-4227-4DE8-919F-4E0E1A8EB701")
        };

        List<Question> actual = randomQuestionService.getQuestionList(questions, randomNumber, blacklist);

        assertEquals(randomNumber, actual.size());
    }

 */

    @Test
    public void validNumber_should_throw_negativeNumber() {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        int negativeNumber = -(Util.getRandomNumber(0, 10000));

        assertThrows(IOException.class, () -> randomQuestionService.validNumber(negativeNumber));
    }

    @Test
    public void validNumber_should_throw_byHighNumber() {
        RandomQuestionService randomQuestionService = new RandomQuestionService();

        int highNumber = Util.getRandomNumber(0, 10000);
        highNumber += TextInput.FREE_TEXT_QUESTIONS.size() +
                SingleChoice.SINGLE_CHOICE_QUESTIONS.size() +
                MultipleChoice.MULTIPLE_CHOICE_QUESTIONS.size();

        int finalHighNumber = highNumber;
        assertThrows(IOException.class, () -> randomQuestionService.validNumber(finalHighNumber));
    }
}
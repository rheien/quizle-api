package org.example.quizleapi.api;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class QuestionControllerTest {

    @Test
    public void isValidNumberOfQuestions_with_Null() {
        boolean result = QuestionController.isValidNumberOfQuestions(null);

        assertFalse(result);
    }

    @Test
    public void isValidNumberOfQuestions_with_emptyString() {
        boolean result = QuestionController.isValidNumberOfQuestions("");

        assertFalse(result);
    }

    @Test
    public void hasValidIDs_with_emptyArray() {
        boolean result = QuestionController.hasValidIDs(new String[]{});

        assertTrue(result);
    }

    @Test
    public void hasValidIDs_with_invalidUUId() {
        String[] excludedIDs = new String[]{UUID.randomUUID().toString(), "invalid"};
        boolean result = QuestionController.hasValidIDs(excludedIDs);

        assertFalse(result);
    }

    @Test
    public void hasValidIDs_with_validUUId() {
        String[] excludedIDs = new String[]{UUID.randomUUID().toString(), UUID.randomUUID().toString()};
        boolean result = QuestionController.hasValidIDs(excludedIDs);

        assertTrue(result);
    }

    @Test
    public void hasValidIDs_with_null() {
        String[] excludedIDs = new String[]{UUID.randomUUID().toString(), null};
        boolean result = QuestionController.hasValidIDs(excludedIDs);

        assertFalse(result);
    }
}
package org.example.quizleapi.questions;

import java.util.Objects;
import java.util.UUID;

public class Question {

    public final UUID id;
    public final String question;
    public String[] answers;
    public final String[] correctAnswers;
    public final QuestionType type;

    public Question(
            UUID id,
            String question,
            String[] answers,
            String[] correctAnswers,
            QuestionType type) {
        this.id = id;
        this.question = question;
        this.answers = answers;
        this.correctAnswers = correctAnswers;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id.equals(question.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

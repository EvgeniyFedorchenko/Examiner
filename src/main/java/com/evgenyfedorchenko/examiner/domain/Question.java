package com.evgenyfedorchenko.examiner.domain;

import com.evgenyfedorchenko.examiner.exceptions.ObjectFieldsAreEqualException;

import java.util.Objects;

public class Question {

    private final String question;
    private final String answer;

    public Question(String question, String answer) {
        validate(question, answer);
        this.question = question;
        this.answer = answer;
    }

    public Question(String question, Integer answer) {
        this.question = question;
        this.answer = String.valueOf(answer);
        validate(question, this.answer);
    }

    private void validate(String question, String answer) {
        if (question.equals(answer)) throw new ObjectFieldsAreEqualException("Object's fields can not be equal");
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(question, question1.question) && Objects.equals(answer, question1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

    @Override
    public String toString() {
        return "Question: " + question + ", answer: " + answer;
    }
}

package com.evgenyfedorchenko.examiner.exceptions;

import com.evgenyfedorchenko.examiner.domain.Question;

public class QuestionAlreadyAddedException extends ExaminerException {

    private final Question question;

    public QuestionAlreadyAddedException(String message, Question question) {
        super(message);
        this.question = question;
    }

    @Override
    public String getUserMessage() {
        return """
                <h2>Oops!</h2>
                <br>
                Your question:<br>
                <b>%s</b><br>
                with answer:<br>
                <b>%s</b><br>
                already added!""".formatted(question.getQuestion(), question.getAnswer());
    }
}

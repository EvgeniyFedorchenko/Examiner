package com.evgenyfedorchenko.examiner.exceptions;

import com.evgenyfedorchenko.examiner.domain.Question;

public abstract class ExaminerException extends RuntimeException {

    final Question question;

    public ExaminerException(String message, Question question) {
        super(message);
        this.question = question;
    }

    public abstract String getUserMessage();
}

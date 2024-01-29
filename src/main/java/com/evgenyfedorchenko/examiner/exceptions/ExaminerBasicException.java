package com.evgenyfedorchenko.examiner.exceptions;

public abstract class ExaminerBasicException extends RuntimeException {

    public ExaminerBasicException(String message) {
        super(message);
    }

    public abstract String getUserMessage();
}

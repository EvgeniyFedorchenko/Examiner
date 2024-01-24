package com.evgenyfedorchenko.examiner.exceptions;

public abstract class ExaminerException extends RuntimeException {

    public ExaminerException(String message) {
        super(message);
    }

    public abstract String getUserMessage();
}

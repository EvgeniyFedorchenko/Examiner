package com.evgenyfedorchenko.examiner.exceptions;

public class CollectionQuestionsIsEmptyException extends ExaminerException {

    public CollectionQuestionsIsEmptyException(String message) {
        super(message);
    }

    @Override
    public String getUserMessage() {
        return """
                <h2>Oops!</h2>
                <br>
                No questions have been added so far!""";
    }
}

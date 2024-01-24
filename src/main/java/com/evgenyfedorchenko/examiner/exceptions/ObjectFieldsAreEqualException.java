package com.evgenyfedorchenko.examiner.exceptions;

public class ObjectFieldsAreEqualException extends ExaminerException {

    public ObjectFieldsAreEqualException(String message) {
        super(message);
    }

    @Override
    public String getUserMessage() {
        return """
                <h2>Oops!</h2>
                <br>
                The question text and the answer text that you gave cannot be equal:<br>
                <b>%s</b><br>
                with answer:<br>
                <b>%s</b><br>
                already added!""";
    }
}

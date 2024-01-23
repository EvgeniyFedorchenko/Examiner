package com.evgenyfedorchenko.examiner.exceptions;

import com.evgenyfedorchenko.examiner.domain.Question;

public class QuestionNotFoundException extends ExaminerException {

    public QuestionNotFoundException(String message, Question question) {
        super(message, question);
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
                isn't found in this collection!""".formatted(question.getQuestion(), question.getAnswer());
    }
}

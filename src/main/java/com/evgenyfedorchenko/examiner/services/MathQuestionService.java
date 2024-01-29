package com.evgenyfedorchenko.examiner.services;

import com.evgenyfedorchenko.examiner.domain.Question;
import com.evgenyfedorchenko.examiner.exceptions.NotAllowedException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;


@Service("MathQuestionService")
public class MathQuestionService implements QuestionService {

    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        throw new NotAllowedException("This method is not allowed");
    }

    @Override
    public Question add(Question question) {
        throw new NotAllowedException("This method is not allowed");
    }

    @Override
    public Question remove(Question question) {
        throw new NotAllowedException("This method is not allowed");
    }

    @Override
    public Collection<Question> getAllQuestions() {
        throw new NotAllowedException("This method is not allowed");
    }

    @Override
    public Question getRandomQuestion() {

        char operation = new char[]{'*', '/', '+', '-'}[random.nextInt(4)];
        int firstOperand = random.nextInt(2001) - 1000;
        int secondOperand;

        do {
            secondOperand = random.nextInt(2001) - 1000;
        } while (secondOperand == 0 && operation == '/');

        int answer = switch (operation) {
            case '*' -> firstOperand * secondOperand;
            case '/' -> firstOperand / secondOperand;
            case '+' -> firstOperand + secondOperand;
            default -> firstOperand - secondOperand;
        };
        String question = firstOperand + " " + operation + " " + secondOperand;

        return new Question(question, String.valueOf(answer));
    }
}

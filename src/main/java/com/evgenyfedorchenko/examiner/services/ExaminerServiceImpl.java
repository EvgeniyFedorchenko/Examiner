package com.evgenyfedorchenko.examiner.services;

import com.evgenyfedorchenko.examiner.domain.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    @Override
    public Collection<Question> getQuestions(int amount) {
        // Задача: создать коллекцию и заполнить её с помощью вызова getRandomQuestion у QuestionService случайными вопросами.
        return null;
    }
}

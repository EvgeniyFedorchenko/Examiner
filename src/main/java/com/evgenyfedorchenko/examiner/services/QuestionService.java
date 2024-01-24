package com.evgenyfedorchenko.examiner.services;

import com.evgenyfedorchenko.examiner.domain.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface QuestionService<T> {

    Question add(String question, T answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAllQuestions();

    Question getRandomQuestion();
}

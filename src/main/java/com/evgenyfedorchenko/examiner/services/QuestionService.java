package com.evgenyfedorchenko.examiner.services;

import com.evgenyfedorchenko.examiner.domain.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAllQuestions();

    Question getRandomQuestion();
}

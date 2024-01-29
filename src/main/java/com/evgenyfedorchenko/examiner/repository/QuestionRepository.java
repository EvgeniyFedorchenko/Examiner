package com.evgenyfedorchenko.examiner.repository;

import com.evgenyfedorchenko.examiner.domain.Question;

import java.util.Collection;


public interface QuestionRepository {

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAllQuestions();
}

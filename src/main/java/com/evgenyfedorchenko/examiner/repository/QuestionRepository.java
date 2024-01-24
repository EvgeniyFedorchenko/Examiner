package com.evgenyfedorchenko.examiner.repository;

import com.evgenyfedorchenko.examiner.domain.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface QuestionRepository {

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAllQuestions();
}

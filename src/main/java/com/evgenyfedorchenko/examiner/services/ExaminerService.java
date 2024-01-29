package com.evgenyfedorchenko.examiner.services;

import com.evgenyfedorchenko.examiner.domain.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(Integer amount);
}

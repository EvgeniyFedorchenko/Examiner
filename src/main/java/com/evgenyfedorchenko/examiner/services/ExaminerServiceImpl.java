package com.evgenyfedorchenko.examiner.services;

import com.evgenyfedorchenko.examiner.domain.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(Integer amount) {

        Set<Question> questionSet = new HashSet<>();
        if (amount <= 0) {
            return questionSet;
        }
        while (questionSet.size() != amount) {
            questionSet.add(questionService.getRandomQuestion());
        }
        return questionSet;
    }
}

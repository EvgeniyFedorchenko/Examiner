package com.evgenyfedorchenko.examiner.services;

import com.evgenyfedorchenko.examiner.domain.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl<T> implements ExaminerService {

    private final QuestionService<String> javaQuestionService;
    private final QuestionService<Integer> mathQuestionService;

    public ExaminerServiceImpl(QuestionService<String> javaQuestionService,
                               QuestionService<Integer> mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(Integer amount) {

        Set<Question> questionSet = new HashSet<>();
        if (amount <= 0) {
            return questionSet;
        }
        while (questionSet.size() != amount) {
            questionSet.add(javaQuestionService.getRandomQuestion());
            questionSet.add(mathQuestionService.getRandomQuestion());
        }
        return questionSet;
    }
}

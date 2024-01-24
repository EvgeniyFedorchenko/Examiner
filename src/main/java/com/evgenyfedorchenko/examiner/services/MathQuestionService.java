package com.evgenyfedorchenko.examiner.services;

import com.evgenyfedorchenko.examiner.domain.Question;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.server.MethodNotAllowedException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Service
public class MathQuestionService implements QuestionService<Integer> {

    private final Set<Question> mathQuestions;

    public MathQuestionService(Set<Question> mathQuestions) {
        this.mathQuestions = mathQuestions;
    }

    @Override
    public Question add(String question, Integer answer) {
        // TODO: 24.01.2024 Разобраться здесь
        Collection<HttpMethod> collection = new HashSet<>();
        throw new MethodNotAllowedException(HttpMethod.valueOf("lfjnal"), collection);
    }

    @Override
    public Question add(Question question) {
//        throw new MethodNotAllowedException("ex mess");
        return null;
    }

    @Override
    public Question remove(Question question) {
        return null;
    }

    @Override
    public Collection<Question> getAllQuestions() {
        return null;
    }

    @Override
    public Question getRandomQuestion() {
        // Генерация вопросов на лету
        return null;
    }
}

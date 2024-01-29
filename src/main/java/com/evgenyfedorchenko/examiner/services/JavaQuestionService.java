package com.evgenyfedorchenko.examiner.services;

import com.evgenyfedorchenko.examiner.domain.Question;
import com.evgenyfedorchenko.examiner.exceptions.CollectionQuestionsIsEmptyException;
import com.evgenyfedorchenko.examiner.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service("JavaQuestionService")
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository questionRepository;
    private final Random random = new Random();

    public JavaQuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAllQuestions() {
        return questionRepository.getAllQuestions();
    }

    @Override
    public Question getRandomQuestion() {

        Collection<Question> allQuestions = questionRepository.getAllQuestions();
        if (allQuestions.isEmpty()) {
            throw new CollectionQuestionsIsEmptyException("Collection of questions isn't found");
        }
        int randomQuestionNumber = random.nextInt(allQuestions.size());
        return allQuestions.stream()
                .skip(randomQuestionNumber)
                .findFirst()
                .orElse(null);

    }
}

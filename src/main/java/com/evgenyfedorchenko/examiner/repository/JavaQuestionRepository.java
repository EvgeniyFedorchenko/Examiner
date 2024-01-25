package com.evgenyfedorchenko.examiner.repository;

import com.evgenyfedorchenko.examiner.domain.Question;
import com.evgenyfedorchenko.examiner.exceptions.QuestionAlreadyAddedException;
import com.evgenyfedorchenko.examiner.exceptions.QuestionNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;

    public JavaQuestionRepository(Set<Question> questions) {
        this.questions = questions;
    }

    @PostConstruct
    void init() {
        // Tests?
        try (BufferedReader br = new BufferedReader(new FileReader(
                "src/main/resources/questions_and_answers_for_JavaQuestionRepository.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String answerText = br.readLine();
                add(new Question(line, answerText));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Question add(Question question) {
        if (questions.add(question)) {
            return question;
        }
        throw new QuestionAlreadyAddedException("Question \"" + question + "\" already added in collection", question);
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        throw new QuestionNotFoundException("Question \"" + question + "\" isn't found in collection", question);
    }

    @Override
    public Collection<Question> getAllQuestions() {
        return new HashSet<>(questions);
    }
}

package com.evgenyfedorchenko.examiner.repository;

import com.evgenyfedorchenko.examiner.domain.Question;
import com.evgenyfedorchenko.examiner.exceptions.QuestionAlreadyAddedException;
import com.evgenyfedorchenko.examiner.exceptions.QuestionNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;

@Repository
public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;

    public JavaQuestionRepository() {
        this.questions = new LinkedHashSet<>();
    }

    @PostConstruct
    public void init() {
        String fileName = "src/main/resources/questions_and_answers_for_JavaQuestionRepository.txt";
        final List<String> lines = new ArrayList<>();
        try {
            lines.addAll(Files.readAllLines(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        IntStream.range(0, lines.size() - 1)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> new Question(lines.get(i), lines.get(i + 1)))
                .forEach(questions::add);
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

package com.evgenyfedorchenko.examiner.services;

import com.evgenyfedorchenko.examiner.domain.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {


    private final List<QuestionService> questionServices;
    private final Random random = new Random();

    public ExaminerServiceImpl(List<QuestionService> questionServices) {
        this.questionServices = questionServices;
    }


    @Override
    public Collection<Question> getQuestions(Integer amount) {

        Set<Question> questionSet = new HashSet<>();
        /* Так как часть вопросов генерируется на лету, нет необходимости проверять,
           что вопросов запрошено не больше, чем есть в репозиториях */
        if (amount <= 0) {
            return questionSet;
        }
        while (questionSet.size() != amount) {
            questionSet.add(random.nextBoolean()
                    ? questionServices.get(0).getRandomQuestion()
                    : questionServices.get(1).getRandomQuestion());
        }
        return questionSet;
    }
}

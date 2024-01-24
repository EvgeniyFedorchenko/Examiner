package com.evgenyfedorchenko.examiner.controllers;

import com.evgenyfedorchenko.examiner.domain.Question;
import com.evgenyfedorchenko.examiner.exceptions.ExaminerException;
import com.evgenyfedorchenko.examiner.services.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class MathQuestionController {

//    @Qualifier("MathQuestionService")
    private final QuestionService<Integer> questionService;

    public MathQuestionController(QuestionService<Integer> questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam(value = "question") String question,
                                @RequestParam(value = "answer") Integer answer) {
        int a = 123;
        return questionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam(value = "question") String question,
                                   @RequestParam(value = "answer") Integer answer) {
        return questionService.remove(new Question(question, answer));
    }

    @GetMapping(path = "/getAll")
    public Collection<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @ExceptionHandler(ExaminerException.class)
    public String handleExceptionOfJavaQuestionController(ExaminerException exception) {
        return exception.getUserMessage();
    }
}

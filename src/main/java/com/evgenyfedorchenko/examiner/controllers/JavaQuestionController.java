package com.evgenyfedorchenko.examiner.controllers;

import com.evgenyfedorchenko.examiner.domain.Question;
import com.evgenyfedorchenko.examiner.exceptions.ExaminerBasicException;
import com.evgenyfedorchenko.examiner.services.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam/java")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(@Qualifier("JavaQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam(value = "question") String question,
                                @RequestParam(value = "answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam(value = "question") String question,
                                   @RequestParam(value = "answer") String answer) {
        return questionService.remove(new Question(question, answer));
    }

    @GetMapping()
    public Collection<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @ExceptionHandler(ExaminerBasicException.class)
    public String handleExceptionOfJavaQuestionController(ExaminerBasicException exception) {
        return exception.getUserMessage();
    }
}

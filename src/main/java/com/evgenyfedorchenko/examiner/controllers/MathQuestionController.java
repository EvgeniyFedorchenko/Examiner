package com.evgenyfedorchenko.examiner.controllers;

import com.evgenyfedorchenko.examiner.domain.Question;
import com.evgenyfedorchenko.examiner.services.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam/math")
public class MathQuestionController {

    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("MathQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add")   // METHOD_NOT_ALLOWED
    public Question addQuestion(@RequestParam(value = "question") String question,
                                @RequestParam(value = "answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping(path = "/remove")   // METHOD_NOT_ALLOWED
    public Question removeQuestion(@RequestParam(value = "question") String question,
                                   @RequestParam(value = "answer") String answer) {
        return questionService.remove(new Question(question, answer));
    }

    @GetMapping()   // METHOD_NOT_ALLOWED
    public Collection<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }
}

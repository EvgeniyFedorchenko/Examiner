package com.evgenyfedorchenko.examiner.services;

import com.evgenyfedorchenko.examiner.Constants;
import com.evgenyfedorchenko.examiner.domain.Question;
import com.evgenyfedorchenko.examiner.exceptions.NotAllowedException;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static com.evgenyfedorchenko.examiner.Constants.MATH_QUESTION_1;
import static com.evgenyfedorchenko.examiner.Constants.QUESTION_1;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MathQuestionServiceTest {

    private final MathQuestionService out = new MathQuestionService();

    @Test
    void should_exception_when_refer_to_add_method_with_question_param() {
        assertThrows(NotAllowedException.class, () -> out.add(QUESTION_1));
    }

    @Test
    void should_exception_when_refer_to_add_method_with_string_params() {
        assertThrows(NotAllowedException.class,
                () -> out.add(Constants.MATH_QUESTION_1.getQuestion(), MATH_QUESTION_1.getAnswer()));
    }

    @Test
    void should_exception_when_refer_to_remove() {
        assertThrows(NotAllowedException.class, () -> out.remove(MATH_QUESTION_1));
    }

    @Test
    void should_exception_when_refer_to_get_all_questions() {
        assertThrows(NotAllowedException.class, out::getAllQuestions);
    }

    @RepeatedTest(100)
    void getRandomQuestion() {
        // invoking
        Question expectedQuestion = out.getRandomQuestion();
        String expectedQuestionText = expectedQuestion.getQuestion();
        // assertions
        assertTrue(expectedQuestionText.matches("-?\\d+\\s[+*/-]\\s-?\\d+"));
    }
}
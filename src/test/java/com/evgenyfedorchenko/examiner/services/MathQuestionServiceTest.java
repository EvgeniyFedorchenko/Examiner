package com.evgenyfedorchenko.examiner.services;

import com.evgenyfedorchenko.examiner.Constants;
import com.evgenyfedorchenko.examiner.domain.Question;
import com.evgenyfedorchenko.examiner.exceptions.NotAllowedException;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static com.evgenyfedorchenko.examiner.Constants.MATH_QUESTION_1;
import static com.evgenyfedorchenko.examiner.Constants.QUESTION_1;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MathQuestionServiceTest {

    private final Set<Question> questions = new HashSet<>();
    private final MathQuestionService out = new MathQuestionService(questions);
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
        // Нейминг в задании конечно не самый удачный, что Question - объект, а String question - его же поле
        // invoking
        Question expectedQuestion = out.getRandomQuestion(); // Объект типа Question
        String expectedQuestionText = expectedQuestion.getQuestion(); // Его поле с самим собственно текстом вопроса
        // assertions
        assertTrue(expectedQuestionText.matches("-?\\d+\\s[+*/-]\\s-?\\d+"));
    }
}
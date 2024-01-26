package com.evgenyfedorchenko.examiner.services;

import com.evgenyfedorchenko.examiner.Constants;
import com.evgenyfedorchenko.examiner.domain.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static com.evgenyfedorchenko.examiner.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    private final QuestionService javaQuestionServiceMock = mock(JavaQuestionService.class);
    private final QuestionService mathQuestionServiceMock = mock(MathQuestionService.class);
    private final ExaminerServiceImpl out = new ExaminerServiceImpl(
            List.of(javaQuestionServiceMock, mathQuestionServiceMock));

    public static Stream<Arguments> provide_params_for_nonpositive_amount_questions() {
        return Stream.of(
                Arguments.of(0), Arguments.of(-4)
        );
    }

    @ParameterizedTest
    @MethodSource("provide_params_for_nonpositive_amount_questions")
    public void get_questions_test_with_nonpositive_amount(int amountOfQuestions) {
        // invoking
        Collection<Question> actualCollection = out.getQuestions(amountOfQuestions);

        // assertion
        assertTrue(actualCollection.isEmpty());
        assertEquals(Constants.TEST_COLLECTION_OF_ZERO_QUESTIONS, actualCollection);
    }

    @Test
    public void get_questions_test_when_positive_amount() {
        //given
        Collection<Question> expectedCollection = new HashSet<>(TEST_COLLECTION_OF_5_QUESTIONS);
        expectedCollection.addAll(TESTS_COLLECTION_OF_5_MATH_QUESTIONS);

        when(mathQuestionServiceMock.getRandomQuestion())
                .thenReturn(MATH_QUESTION_1)
                .thenReturn(MATH_QUESTION_2)
                .thenReturn(MATH_QUESTION_3)
                .thenReturn(MATH_QUESTION_4)
                .thenReturn(MATH_QUESTION_5);
        when(javaQuestionServiceMock.getRandomQuestion())
                .thenReturn(QUESTION_1)
                .thenReturn(QUESTION_2)
                .thenReturn(QUESTION_3)
                .thenReturn(QUESTION_4)
                .thenReturn(QUESTION_5);

        // invoking
        Collection<Question> actualCollection = out.getQuestions(10);

        // assertion
        assertEquals(expectedCollection, actualCollection);
    }
}

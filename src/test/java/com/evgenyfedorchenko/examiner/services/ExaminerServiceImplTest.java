package com.evgenyfedorchenko.examiner.services;

import com.evgenyfedorchenko.examiner.domain.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Stream;

import static com.evgenyfedorchenko.examiner.services.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    QuestionService questionServiceMock;
    @InjectMocks
    ExaminerServiceImpl out;

    public static Stream<Arguments> provide_params_for_nonpositive_amount_questions() {
        return Stream.of(
                Arguments.of(0), Arguments.of(-4)
        );
    }

    @ParameterizedTest
    @MethodSource("provide_params_for_nonpositive_amount_questions")
    public void get_questions_test_with_zero_amount(int amountOfQuestions) {
        // invoking
        Collection<Question> actualCollection = out.getQuestions(amountOfQuestions);

        // assertion
        assertTrue(actualCollection.isEmpty());
        assertEquals(TEST_COLLECTION_OF_ZERO_QUESTIONS, actualCollection);
    }

    @Test
    public void get_questions_test_when_positive_amount() {
        //given
        Collection<Question> expectedCollection = new HashSet<>(TEST_COLLECTION_OF_5_QUESTIONS);

        // invoking
        when(questionServiceMock.getRandomQuestion())
                .thenReturn(QUESTION_1)
                .thenReturn(QUESTION_2)
                .thenReturn(QUESTION_3)
                .thenReturn(QUESTION_4)
                .thenReturn(QUESTION_5);

        Collection<Question> actualCollection = out.getQuestions(5);

        // assertion
        assertEquals(expectedCollection, actualCollection);
    }
}

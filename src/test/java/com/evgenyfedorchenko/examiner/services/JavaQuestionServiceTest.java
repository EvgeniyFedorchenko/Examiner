package com.evgenyfedorchenko.examiner.services;

import com.evgenyfedorchenko.examiner.domain.Question;
import com.evgenyfedorchenko.examiner.exceptions.QuestionAlreadyAddedException;
import com.evgenyfedorchenko.examiner.exceptions.QuestionNotFoundException;
import com.evgenyfedorchenko.examiner.repository.JavaQuestionRepository;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Stream;

import static com.evgenyfedorchenko.examiner.Constants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JavaQuestionServiceTest {

    private final JavaQuestionRepository javaQuestionRepositoryMock = mock(JavaQuestionRepository.class);
    private final JavaQuestionService out = new JavaQuestionService(javaQuestionRepositoryMock);

    @Test
    public void add_question_on_adding_method_with_questions_params() {
        // given
        when(javaQuestionRepositoryMock.add(any(Question.class))).thenReturn(QUESTION_1);
        // invoking
        Question actualQuestion = out.add(QUESTION_1);
        // assertions
        assertEquals(QUESTION_1, actualQuestion);


    }

    @Test
    public void add_question_on_adding_method_with_strings_params() {
        // given
        when(javaQuestionRepositoryMock.add(any(Question.class))).thenReturn(QUESTION_1);
        // invoking
        Question actualQuestion = out.add(QUESTION_1.getQuestion(), QUESTION_1.getAnswer());
        // assertions
        assertEquals(QUESTION_1, actualQuestion);
    }

    @Test
    public void should_exception_when_adding_already_added_object_in_adding_method_with_questions_params() {
        // given
        when(javaQuestionRepositoryMock.add(any(Question.class)))
                .thenThrow(QuestionAlreadyAddedException.class);
        // invoking and assertions
        assertThrows(QuestionAlreadyAddedException.class, () -> out.add(QUESTION_1));
    }

    @Test
    public void should_exception_when_adding_already_added_object_in_adding_method_with_strings_params() {
        // given
        when(javaQuestionRepositoryMock.add(any(Question.class)))
                .thenThrow(QuestionAlreadyAddedException.class);
        // invoking and assertions
        assertThrows(QuestionAlreadyAddedException.class,
                () -> out.add("question1", "answer1"));
    }

    @Test
    public void remove_question_positive_test() {
        // given
        when(javaQuestionRepositoryMock.remove(any(Question.class))).thenReturn(QUESTION_1);
        // invoking
        Question actualQuestion = out.remove(QUESTION_1);
        // assertion
        assertEquals(QUESTION_1, actualQuestion);


        /*Set<Question> expectedSet = new HashSet<>(TEST_COLLECTION_OF_4_QUESTIONS);
        setUnderTest.addAll(TEST_COLLECTION_OF_5_QUESTIONS);
        // invoking
        Question actualQuestion = out.remove(QUESTION_5);
        // assertions
        assertEquals(expectedSet, setUnderTest);
        assertEquals(QUESTION_5, actualQuestion);*/
    }

    @Test
    public void should_exception_when_remove_missing_question() {
        // given
        when(javaQuestionRepositoryMock.remove(any(Question.class)))
                .thenThrow(QuestionNotFoundException.class);
        // invoking and assertions
        assertThrows(QuestionNotFoundException.class, () -> out.remove(QUESTION_1));
    }

    private static Stream<Arguments> provide_params_for_get_all_method_test() {
        return Stream.of(
                Arguments.of(Set.of(QUESTION_1)),
                Arguments.of(TEST_COLLECTION_OF_ZERO_QUESTIONS),
                Arguments.of(TEST_COLLECTION_OF_5_QUESTIONS));
    }

    @ParameterizedTest
    @MethodSource("provide_params_for_get_all_method_test")
    public void get_all_questions_test(Collection<Question> expectedCollection) {
        // given
        when(javaQuestionRepositoryMock.getAllQuestions()).thenReturn(expectedCollection);
        // invoking
        Collection<Question> actualCollection = out.getAllQuestions();
        // assertions
        assertEquals(expectedCollection, actualCollection);
    }

    @RepeatedTest(100)
    public void get_random_question_test() {
        // given
        when(javaQuestionRepositoryMock.getAllQuestions()).thenReturn(TEST_COLLECTION_OF_5_QUESTIONS);
        // invoking and assertions
        assertTrue(TEST_COLLECTION_OF_5_QUESTIONS.contains(out.getRandomQuestion()));
    }
}


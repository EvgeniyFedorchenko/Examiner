package com.evgenyfedorchenko.examiner.repository;

import com.evgenyfedorchenko.examiner.domain.Question;
import com.evgenyfedorchenko.examiner.exceptions.QuestionAlreadyAddedException;
import com.evgenyfedorchenko.examiner.exceptions.QuestionNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static com.evgenyfedorchenko.examiner.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JavaQuestionRepositoryTest {

    private final JavaQuestionRepository out = new JavaQuestionRepository();

    @BeforeEach
    public void beforeEach() {
        out.add(QUESTION_1);
        out.add(QUESTION_2);
        out.add(QUESTION_3);
        out.add(QUESTION_4);
    }

    @AfterEach
    public void afterEach() {
        out.getAllQuestions().forEach(out::remove);
    }

    @Test
    public void add_positive_test() {
        // given
        Set<Question> expectedSet = new HashSet<>(TEST_COLLECTION_OF_5_QUESTIONS);
        // invoking
        Question actualQuestion = out.add(QUESTION_5);
        // assertions
        assertEquals(QUESTION_5, actualQuestion);
        assertEquals(expectedSet, out.getAllQuestions());
    }

    @Test
    public void should_exception_when_add_already_added_question() {
        // given
        Set<Question> setBeforeException = new HashSet<>(TEST_COLLECTION_OF_4_QUESTIONS);
        // invoking and assertions
        assertThrows(QuestionAlreadyAddedException.class, () -> out.add(QUESTION_1));
        assertEquals(setBeforeException, out.getAllQuestions());
    }

    @Test
    public void remove_positive_test() {
        // given
        Set<Question> expectedSet = new HashSet<>(TEST_COLLECTION_OF_3_QUESTIONS);
        // invoking
        Question actualQuestion = out.remove(QUESTION_4);
        // assertion
        assertEquals(QUESTION_4, actualQuestion);
        assertEquals(expectedSet, out.getAllQuestions());
    }

    @Test
    public void should_exception_when_remove_missing_question() {
        // given
        Set<Question> setBeforeException = new HashSet<>(TEST_COLLECTION_OF_4_QUESTIONS);
        // assertions
        assertThrows(QuestionNotFoundException.class, () -> out.remove(QUESTION_5));
        assertEquals(setBeforeException, out.getAllQuestions());
    }

    private static Stream<Arguments> provide_params_for_get_all_method_test() {
        // given
        return Stream.of(
                Arguments.of(Set.of(QUESTION_1)),
                Arguments.of(TEST_COLLECTION_OF_ZERO_QUESTIONS),
                Arguments.of(TEST_COLLECTION_OF_5_QUESTIONS));
    }

    @ParameterizedTest
    @MethodSource("provide_params_for_get_all_method_test")
    public void get_all_questions_test(Collection<Question> expectedCollection) {

        // given (очищаем вопросы, добавленные в BeforeEach)
        Collection<Question> collection = out.getAllQuestions();
        for (Question question : collection) {
            out.remove(question);
        }
        // (вставляем наши вопросы из стрима)
        for (Question question : expectedCollection) {
            out.add(question);
        }
        // invoking
        Collection<Question> actualCollection = out.getAllQuestions();
        // assertions
        assertEquals(expectedCollection, actualCollection);
    }
}
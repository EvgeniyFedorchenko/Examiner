package com.evgenyfedorchenko.examiner.repository;

import com.evgenyfedorchenko.examiner.domain.Question;
import com.evgenyfedorchenko.examiner.exceptions.QuestionAlreadyAddedException;
import com.evgenyfedorchenko.examiner.exceptions.QuestionNotFoundException;
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

    private final Set<Question> setUnderTest = new HashSet<>();
    private final JavaQuestionRepository out = new JavaQuestionRepository(setUnderTest);

    @Test
    public void add_positive_test() {
        // given
        Set<Question> expectedSet = new HashSet<>(TEST_COLLECTION_OF_5_QUESTIONS);
        setUnderTest.addAll(TEST_COLLECTION_OF_4_QUESTIONS);
        // invoking
        Question actualQuestion = out.add(QUESTION_5);
        // assertions
        assertEquals(QUESTION_5, actualQuestion);
        assertEquals(expectedSet, setUnderTest);
    }

    @Test
    public void should_exception_when_add_already_added_question() {
        // given
        setUnderTest.add(QUESTION_1);
        // invoking and assertions
        // TODO: 25.01.2024 Стоит ли проверить, что в исключительной ситуации вопрос реально не добавляется?
        assertThrows(QuestionAlreadyAddedException.class, () -> out.add(QUESTION_1));
    }

    @Test
    public void remove_positive_test() {
        // given
        Set<Question> expectedSet = new HashSet<>(TEST_COLLECTION_OF_4_QUESTIONS);
        setUnderTest.addAll(TEST_COLLECTION_OF_5_QUESTIONS);
        // invoking
        Question actualQuestion = out.remove(QUESTION_5);
        // assertion
        assertEquals(QUESTION_5, actualQuestion);
        assertEquals(expectedSet, setUnderTest);
    }

    @Test
    public void should_exception_when_remove_missing_question() {
        assertThrows(QuestionNotFoundException.class, () -> out.remove(QUESTION_1));
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
        // given
        setUnderTest.addAll(expectedCollection);
        // invoking
        Collection<Question> actualCollection = out.getAllQuestions();
        // assertions
        assertEquals(expectedCollection, actualCollection);
    }
}

package com.evgenyfedorchenko.examiner.services;

import com.evgenyfedorchenko.examiner.domain.Question;
import com.evgenyfedorchenko.examiner.exceptions.QuestionAlreadyAddedException;
import com.evgenyfedorchenko.examiner.exceptions.QuestionNotFoundException;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static com.evgenyfedorchenko.examiner.services.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
}
/*
    private final Set<Question> setUnderTest = new HashSet<>();
    JavaQuestionService out = new JavaQuestionService(setUnderTest);

    @Test
    public void add_question_on_adding_method_with_questions_params() {
        // given
        Set<Question> expectedCollection = new HashSet<>(Set.of(QUESTION_1));
        // invoking
        Question actualQuestion = out.add(QUESTION_1);
        // assertions
        assertEquals(QUESTION_1, actualQuestion);
        assertTrue(expectedCollection.containsAll(setUnderTest));
        assertEquals(setUnderTest, expectedCollection);
    }

    @Test
    public void add_question_on_adding_method_with_strings_params() {
        // given
        Set<Question> expectedSet = new HashSet<>(Set.of(QUESTION_1));
        // invoking
        Question actualQuestion = out.add("question1", "answer1");
        // assertions
        assertEquals(QUESTION_1, actualQuestion);
        assertTrue(expectedSet.containsAll(setUnderTest));
        assertEquals(setUnderTest, expectedSet);
    }

    @Test
    public void should_exception_when_adding_method_with_questions_params() {
        // invoking
        out.add(QUESTION_1);
        // assertions
        assertThrows(QuestionAlreadyAddedException.class, () -> out.add(QUESTION_1));
    }

    @Test
    public void should_exception_when_adding_method_with_strings_params() {
        // invoking
        out.add("question1", "answer1");
        // assertions
        assertThrows(QuestionAlreadyAddedException.class,
                () -> out.add("question1", "answer1"));
    }

    @Test
    public void remove_question_positive_test() {
        // given
        Set<Question> expectedSet = new HashSet<>(TEST_COLLECTION_OF_4_QUESTIONS);
        setUnderTest.addAll(TEST_COLLECTION_OF_5_QUESTIONS);
        // invoking
        Question actualQuestion = out.remove(QUESTION_5);
        // assertions
        assertEquals(expectedSet, setUnderTest);
        assertEquals(QUESTION_5, actualQuestion);
    }

    @Test
    public void should_exception_when_remove_missing_question() {
        // given
        setUnderTest.addAll(TEST_COLLECTION_OF_4_QUESTIONS);
        // assertions
        assertThrows(QuestionNotFoundException.class, () -> out.remove(QUESTION_5));
    }

    public static Stream<Arguments> provide_params_for_get_all_method_test() {
        return Stream.of(
                Arguments.of(Set.of(QUESTION_1)),
                Arguments.of(TEST_COLLECTION_OF_ZERO_QUESTIONS),
                Arguments.of(TEST_COLLECTION_OF_5_QUESTIONS));
    }

    @ParameterizedTest
    @MethodSource("provide_params_for_get_all_method_test")
    public void get_all_method_test(Set<Question> setOfQuestions) {
        // given
        setUnderTest.addAll(setOfQuestions);
        // invoking
        Collection<Question> actualCollection = out.getAllQuestions();
        // assertions
        assertEquals(setOfQuestions, actualCollection);
    }

    @RepeatedTest(100)
    public void get_random_question_test() {
        // given
        setUnderTest.addAll(TEST_COLLECTION_OF_5_QUESTIONS);
        // invoking and assertions
        assertTrue(TEST_COLLECTION_OF_5_QUESTIONS.contains(out.getRandomQuestion()));
    }
}
*/

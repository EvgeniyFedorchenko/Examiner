package com.evgenyfedorchenko.examiner;

import com.evgenyfedorchenko.examiner.domain.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Constants {

    public static final Question MATH_QUESTION_1 = new Question("1 - 1", "0");
    public static final Question MATH_QUESTION_2 = new Question("-1 + -1", "0");
    public static final Question MATH_QUESTION_3 = new Question("-1 / -1", "1");
    public static final Question MATH_QUESTION_4 = new Question("1 * -1", "-1");
    public static final Question MATH_QUESTION_5 = new Question("1 / 1", "1");


    public static final Collection<Question> TESTS_COLLECTION_OF_5_MATH_QUESTIONS = new HashSet<>(
            Set.of(MATH_QUESTION_1, MATH_QUESTION_2, MATH_QUESTION_3, MATH_QUESTION_4, MATH_QUESTION_5));


    public static final Question QUESTION_1 = new Question("question1", "answer1");
    public static final Question QUESTION_2 = new Question("question2", "answer2");
    public static final Question QUESTION_3 = new Question("question3", "answer3");
    public static final Question QUESTION_4 = new Question("question4", "answer4");
    public static final Question QUESTION_5 = new Question("question5", "answer5");


    public static final Collection<Question> TEST_COLLECTION_OF_5_QUESTIONS = new HashSet<>(
            Set.of(QUESTION_1, QUESTION_2, QUESTION_3, QUESTION_4, QUESTION_5));

    public static final Collection<Question> TEST_COLLECTION_OF_4_QUESTIONS = new HashSet<>(
            Set.of(QUESTION_1, QUESTION_2, QUESTION_3, QUESTION_4));

    public static final Collection<Question> TEST_COLLECTION_OF_ZERO_QUESTIONS = new HashSet<>();

}

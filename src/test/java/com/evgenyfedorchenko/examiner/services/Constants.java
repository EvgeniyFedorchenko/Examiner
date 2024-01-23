package com.evgenyfedorchenko.examiner.services;

import com.evgenyfedorchenko.examiner.domain.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Constants {

    static final Question QUESTION_1 = new Question("question1", "answer1");
    static final Question QUESTION_2 = new Question("question2", "answer2");
    static final Question QUESTION_3 = new Question("question3", "answer3");
    static final Question QUESTION_4 = new Question("question4", "answer4");
    static final Question QUESTION_5 = new Question("question5", "answer5");


    static final Collection<Question> TEST_COLLECTION_OF_5_QUESTIONS = new HashSet<>(
            Set.of(QUESTION_1, QUESTION_2, QUESTION_3, QUESTION_4, QUESTION_5));
    static final Collection<Question> TEST_COLLECTION_OF_4_QUESTIONS = new HashSet<>(
            Set.of(QUESTION_1, QUESTION_2, QUESTION_3, QUESTION_4));
    static final Collection<Question> TEST_COLLECTION_OF_ZERO_QUESTIONS = new HashSet<>();

}

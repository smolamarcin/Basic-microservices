package com.smola.socialmultiplication.service;

import com.smola.socialmultiplication.domain.Multiplication;
import com.smola.socialmultiplication.domain.MultiplicationResultAttempt;


public interface MultiplicationService {
    Multiplication createRandomMultiplication();

    boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);
}

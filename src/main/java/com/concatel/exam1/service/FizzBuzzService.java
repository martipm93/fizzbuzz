package com.concatel.exam1.service;

import com.concatel.exam1.persistence.model.FizzBuzz;

import java.io.Serializable;

public interface FizzBuzzService extends Serializable {
    FizzBuzz findByName(int firstNumber);
}

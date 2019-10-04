package com.concatel.exam1.service;

import com.concatel.exam1.persistence.model.FizzBuzzClient;

import java.io.Serializable;

public interface FizzBuzzService extends Serializable {
    FizzBuzzClient findByName(int firstNumber);
}

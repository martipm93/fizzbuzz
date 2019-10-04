package com.concatel.exam1.service;

import java.io.Serializable;

public interface FizzBuzzService<T> extends Serializable {
    T findByName(int firstNumber);
}

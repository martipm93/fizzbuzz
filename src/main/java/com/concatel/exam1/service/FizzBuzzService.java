package com.concatel.exam1.service;

import java.io.Serializable;
import java.util.List;

public interface FizzBuzzService extends Serializable {
    List<String> findByName(int firstNumber);
}

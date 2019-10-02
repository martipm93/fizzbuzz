package com.concatel.exam1.service.impl;

import com.concatel.exam1.persistence.dao.FizzBuzzFileDao;
import com.concatel.exam1.persistence.model.FizzBuzz;
import com.concatel.exam1.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

    //@Autowired
    FizzBuzzFileDao dao;

    @Override
    public FizzBuzz findByName(int firstNumber) {

        IntStream range = IntStream.rangeClosed(firstNumber, 1000);

        // TODO - Posar try catch amb classe custom d'excepcions.
        FizzBuzz fizzBuzz = new FizzBuzz(range.parallel().mapToObj(FizzBuzzServiceImpl::calculateFizzBuzz)
                .collect(Collectors.joining(", ")));
        return fizzBuzz;
    }

    public static String calculateFizzBuzz(int number) {
        String fizzBuzzWord;

        if (number % 3 == 0 && number % 5 == 0) {
            fizzBuzzWord = "fizzbuzz";
        } else if (number % 3 == 0) {
            fizzBuzzWord = "fizz";
        } else if (number % 5 == 0) {
            fizzBuzzWord = "buzz";
        } else {
            fizzBuzzWord = Integer.toString(number);
        }
        return fizzBuzzWord;
    }
}

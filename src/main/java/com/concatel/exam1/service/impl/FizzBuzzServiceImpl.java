package com.concatel.exam1.service.impl;

import com.concatel.exam1.persistence.dao.FizzBuzzFileDao;
import com.concatel.exam1.persistence.model.FizzBuzzClient;
import com.concatel.exam1.persistence.model.FizzBuzzEntry;
import com.concatel.exam1.service.FizzBuzzService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

    //@Autowired
    FizzBuzzFileDao dao;

    @Override
    public FizzBuzzClient findByName(int firstNumber) {

        IntStream range = IntStream.rangeClosed(firstNumber, 1000);

        // TODO - Posar try catch amb classe custom d'excepcions.

        List<String> fizzbuzzList = range.parallel().mapToObj(FizzBuzzServiceImpl::calculateFizzBuzz)
                .collect(Collectors.toList());

        FizzBuzzEntry fizzBuzzEntry = new FizzBuzzEntry(fizzbuzzList.stream().parallel().collect(Collectors.joining(", ")), ZonedDateTime.of(LocalDateTime.now(),
                ZoneId.systemDefault()).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        FizzBuzzClient fizzBuzzClient = new FizzBuzzClient(fizzbuzzList);
        return fizzBuzzClient;
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

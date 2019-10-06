package com.concatel.exam1.service.impl;

import com.concatel.exam1.constants.FizzBuzzConstants;
import com.concatel.exam1.persistence.dao.FizzBuzzFileDao;
import com.concatel.exam1.persistence.model.FizzBuzzClient;
import com.concatel.exam1.persistence.model.FizzBuzzEntry;
import com.concatel.exam1.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService<FizzBuzzClient> {

    @Autowired
    FizzBuzzFileDao<FizzBuzzEntry> dao;

    @Override
    @Async("asyncExecutor")
    public CompletableFuture<FizzBuzzClient> findByName(int firstNumber) {
        
        IntStream range = IntStream.rangeClosed(firstNumber, FizzBuzzConstants.LIMIT_FIZZBUZZ_NUMBER);

        // TODO - Posar try catch amb classe custom d'excepcions.

        //Get the list of fizz-buzz strings concurrently with stream parallel.
        List<String> fizzbuzzList = range.parallel().mapToObj(FizzBuzzServiceImpl::calculateFizzBuzz)
                .collect(Collectors.toList());

        //Get the fizz-buzz string representation and the timestamp and set it all into the FizzBuzzEntry object.
        FizzBuzzEntry fizzBuzzEntry = new FizzBuzzEntry(fizzbuzzList.stream().parallel()
                .collect(Collectors.joining(", ")), ZonedDateTime.of(LocalDateTime.now(),
                ZoneId.systemDefault()).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        //Write the FizzBuzzEntry object in the file.
        dao.write(fizzBuzzEntry);

        //Return the FizzBuzzClient object with the list of the fizz-buzz strings.
        FizzBuzzClient fizzBuzzClient = new FizzBuzzClient(fizzbuzzList);
        return CompletableFuture.completedFuture(fizzBuzzClient);
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

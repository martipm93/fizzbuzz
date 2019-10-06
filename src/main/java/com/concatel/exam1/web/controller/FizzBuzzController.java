package com.concatel.exam1.web.controller;

import com.concatel.exam1.exceptions.FizzBuzzNullCustomException;
import com.concatel.exam1.persistence.model.FizzBuzzClient;
import com.concatel.exam1.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/api/fizzbuzz")
public class FizzBuzzController {

    @Autowired
    private FizzBuzzService<FizzBuzzClient> fizzBuzzService;

    @RequestMapping(value = "/{firstNumber}", method = RequestMethod.GET)
    @ResponseBody
    public FizzBuzzClient findOne ( @PathVariable("firstNumber" ) Integer firstNumberParameter ) {

        FizzBuzzClient fizzBuzzClient = new FizzBuzzClient();

        try {

            if ( firstNumberParameter == null ) {
                throw new FizzBuzzNullCustomException("firstNumberParameter");
            }

            fizzBuzzClient = fizzBuzzService.findByName(firstNumberParameter).get();

            if ( fizzBuzzClient == null ) {
                throw new FizzBuzzNullCustomException("fizzBuzzClient");
            }

        } catch ( FizzBuzzNullCustomException e ) {
            e.printStackTrace();
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        } catch ( ExecutionException e ) {
            e.printStackTrace();
        }

        return fizzBuzzClient;
    }
}

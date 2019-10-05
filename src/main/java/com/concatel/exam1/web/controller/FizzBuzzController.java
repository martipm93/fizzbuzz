package com.concatel.exam1.web.controller;

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
    public FizzBuzzClient findOne(@PathVariable("firstNumber") int firstNumber) throws InterruptedException, ExecutionException {

        return fizzBuzzService.findByName(firstNumber).get();
    }
}

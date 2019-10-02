package com.concatel.exam1.web.controller;

import com.concatel.exam1.persistence.model.FizzBuzz;
import com.concatel.exam1.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/fizzbuzz")
public class FizzBuzzController {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @RequestMapping(value = "/{firstNumber}", method = RequestMethod.GET)
    @ResponseBody
    public FizzBuzz findOne(@PathVariable("firstNumber") int firstNumber) {

        return fizzBuzzService.findByName(firstNumber);
    }
}

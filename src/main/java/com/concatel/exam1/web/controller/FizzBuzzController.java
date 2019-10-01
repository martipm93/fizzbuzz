package com.concatel.exam1.web.controller;

import com.concatel.exam1.persistence.model.FizzBuzz;
import com.concatel.exam1.service.FizzBuzzService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/fizzbuzz")
public class FizzBuzzController {

    private FizzBuzzService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public FizzBuzz findOne(@PathVariable("id") final int id) {

        //Temporary response.
        FizzBuzz fizzBuzz = new FizzBuzz();
        return fizzBuzz;

        // TODO - make the logic into service and here only use that service method in the return.
    }
}

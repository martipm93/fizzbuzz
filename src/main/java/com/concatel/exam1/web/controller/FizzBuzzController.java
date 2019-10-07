package com.concatel.exam1.web.controller;

import com.concatel.exam1.exceptions.FizzBuzzNullCustomException;
import com.concatel.exam1.persistence.model.FizzBuzzClient;
import com.concatel.exam1.service.FizzBuzzService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/api/fizzbuzz")
public class FizzBuzzController {

    @Autowired
    private FizzBuzzService<FizzBuzzClient> fizzBuzzService;

    private static final Logger logger = LogManager.getLogger(FizzBuzzController.class);

    @RequestMapping(value = "/{firstNumber}", method = RequestMethod.GET)
    @ResponseBody
    public FizzBuzzClient findOne ( @PathVariable("firstNumber" ) Integer firstNumberParameter ) {

        logger.info("Initiation of the 'findOne' method of FizzBuzzController.");

        FizzBuzzClient fizzBuzzClient = new FizzBuzzClient();

        try {

            if ( firstNumberParameter == null ) {
                throw new FizzBuzzNullCustomException("firstNumberParameter");
            }

            fizzBuzzClient = fizzBuzzService.findById(firstNumberParameter).get();

            if ( fizzBuzzClient == null ) {
                throw new FizzBuzzNullCustomException("fizzBuzzClient");
            }

        } catch ( FizzBuzzNullCustomException e ) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        } catch ( ExecutionException e ) {
            e.printStackTrace();
        }

        logger.info("End of the 'findOne' method of FizzBuzzController.");

        return fizzBuzzClient;
    }
}

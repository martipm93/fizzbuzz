package com.concatel.exam1.exceptions;

public class FizzBuzzNullCustomException extends Exception {

    public FizzBuzzNullCustomException ( String nullLocation ) {
        super ( "A null value has been set in: " + nullLocation );

    }
}

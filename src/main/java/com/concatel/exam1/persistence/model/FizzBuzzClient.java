package com.concatel.exam1.persistence.model;

import java.util.List;

public class FizzBuzzClient {

    private List<String> fizzBuzzList;

    public FizzBuzzClient () {

    }

    public FizzBuzzClient ( List<String> fizzbuzzList ) {
        this.fizzBuzzList = fizzbuzzList;
    }

    public List<String> getFizzBuzzList() {
        return fizzBuzzList;
    }

    public void setFizzBuzzList ( List<String> fizzBuzzList ) {
        this.fizzBuzzList = fizzBuzzList;
    }

}

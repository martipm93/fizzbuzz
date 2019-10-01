package com.concatel.exam1.persistence.model;

import java.util.Objects;

public class FizzBuzz {

    private String fizzBuzzString;

    public FizzBuzz() {

    }

    public FizzBuzz(String fizzBuzzString) {
        this.fizzBuzzString = fizzBuzzString;
    }

    public String getFizzBuzzString() {
        return fizzBuzzString;
    }

    public void setFizzBuzzString(String fizzBuzzString) {
        this.fizzBuzzString = fizzBuzzString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FizzBuzz fizzBuzz = (FizzBuzz) o;
        return Objects.equals(fizzBuzzString, fizzBuzz.fizzBuzzString);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fizzBuzzString);
    }

    @Override
    public String toString() {
        return "FizzBuzz{" +
                "fizzBuzzString='" + fizzBuzzString + '\'' +
                '}';
    }
}

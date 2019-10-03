package com.concatel.exam1.persistence.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class FizzBuzz {

    private List<String> fizzBuzzString;

    private LocalDate timeStamp;

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

    public FizzBuzz() {

    }

    public FizzBuzz(List<String> fizzBuzzString) {
        this.fizzBuzzString = fizzBuzzString;
    }

    public List<String> getFizzBuzzString() {
        return fizzBuzzString;
    }

    public void setFizzBuzzString(List<String> fizzBuzzString) {
        this.fizzBuzzString = fizzBuzzString;
    }

    @Override
    public String toString() {
        return "FizzBuzz{" +
                "fizzBuzzString=" + fizzBuzzString +
                ", timeStamp=" + timeStamp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FizzBuzz fizzBuzz = (FizzBuzz) o;
        return Objects.equals(fizzBuzzString, fizzBuzz.fizzBuzzString) &&
                Objects.equals(timeStamp, fizzBuzz.timeStamp);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fizzBuzzString, timeStamp);
    }
}

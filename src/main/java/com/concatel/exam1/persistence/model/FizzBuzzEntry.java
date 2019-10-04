package com.concatel.exam1.persistence.model;

import java.time.LocalDate;
import java.util.Objects;

public class FizzBuzzEntry {

    private String fizzBuzzString;

    private String timeStamp;

    public FizzBuzzEntry() {

    }

    public FizzBuzzEntry(String fizzBuzzString, String timeStamp) {
        this.fizzBuzzString = fizzBuzzString;
        this.timeStamp = timeStamp;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }


    public String getfizzBuzzString() {
        return fizzBuzzString;
    }

    public void setfizzBuzzString(String fizzBuzzString) {
        this.fizzBuzzString = fizzBuzzString;
    }

    @Override
    public String toString() {
        return "FizzBuzzEntry{" +
                "timeStamp=" + timeStamp +
                ", fizzBuzzString=" + fizzBuzzString +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FizzBuzzEntry fizzBuzzEntry = (FizzBuzzEntry) o;
        return Objects.equals(fizzBuzzString, fizzBuzzEntry.fizzBuzzString) &&
                Objects.equals(timeStamp, fizzBuzzEntry.timeStamp);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fizzBuzzString, timeStamp);
    }
}

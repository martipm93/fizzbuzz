package com.concatel.exam1.persistence.model;

import java.util.Objects;

public class FizzBuzzEntry {

    private String fizzBuzzString;

    private String timestamp;

    public FizzBuzzEntry() {

    }

    public FizzBuzzEntry(String fizzBuzzString, String timestamp) {
        this.fizzBuzzString = fizzBuzzString;
        this.timestamp = timestamp;
    }

    public String gettimestamp() {
        return timestamp;
    }

    public void settimestamp(String timestamp) {
        this.timestamp = timestamp;
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
                "timestamp=" + timestamp +
                ", fizzBuzzString=" + fizzBuzzString +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FizzBuzzEntry fizzBuzzEntry = (FizzBuzzEntry) o;
        return Objects.equals(fizzBuzzString, fizzBuzzEntry.fizzBuzzString) &&
                Objects.equals(timestamp, fizzBuzzEntry.timestamp);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fizzBuzzString, timestamp);
    }
}

package com.concatel.exam1.service;

import com.concatel.exam1.persistence.model.FizzBuzzClient;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

public interface FizzBuzzService<T> extends Serializable {
    CompletableFuture<FizzBuzzClient> findByName(Integer firstNumber)  throws InterruptedException;
}

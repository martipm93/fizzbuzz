package com.concatel.exam1.persistence.dao;

import java.io.Serializable;

public interface FizzBuzzFileDao<T> extends Serializable {
    void write (T t);
}

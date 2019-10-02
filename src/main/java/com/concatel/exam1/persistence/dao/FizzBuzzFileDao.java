package com.concatel.exam1.persistence.dao;

import com.concatel.exam1.persistence.model.FizzBuzz;
import org.springframework.data.repository.CrudRepository;

public interface FizzBuzzFileDao extends CrudRepository<FizzBuzz, Long> {
}

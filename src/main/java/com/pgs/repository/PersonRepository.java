package com.pgs.repository;

import com.pgs.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Luke on 2017-04-02.
 */

public interface PersonRepository extends CrudRepository<Person, Long> {

    @Override
    List<Person> findAll();

    Person findById(Long id);


}

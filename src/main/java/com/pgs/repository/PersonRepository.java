package com.pgs.repository;

import com.pgs.entity.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Luke on 2017-04-02.
 */

public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findById(Long id);


}

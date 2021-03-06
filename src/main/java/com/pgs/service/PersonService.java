package com.pgs.service;

import com.pgs.dto.PersonDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Luke on 2017-04-02.
 */
public interface PersonService {
    List<PersonDTO> findAll();

    PersonDTO findById(@PathVariable("id") Long id);

    void add(PersonDTO personDTO);

    void delete(Long id);

    void update(PersonDTO personDTO);
}

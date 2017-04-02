package com.pgs.service;

import com.pgs.dto.PersonDTO;
import com.pgs.mapper.PersonMapper;
import com.pgs.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Luke on 2017-04-02.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<PersonDTO> findAll() {
        return personMapper.toDTO(personRepository.findAll());
    }

    @Override
    public PersonDTO findById(@PathVariable("id") Long id) {
        return personMapper.toDTO(personRepository.findById(id));
    }

    @Override
    public void add(PersonDTO personDTO) {
        personRepository.save(personMapper.toEntity(personDTO));
    }

    @Override
    public void delete(Long id) {
        personRepository.delete(id);
    }


}
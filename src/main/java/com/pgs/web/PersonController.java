package com.pgs.web;

import com.pgs.dto.PersonDTO;
import com.pgs.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Luke on 2017-04-02.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<PersonDTO> findAll() {
        return personService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @ResponseBody
    public PersonDTO findById(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@Valid @RequestBody PersonDTO personDTO) {
        personService.add(personDTO);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        personService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@Valid @RequestBody PersonDTO personDTO) {
        personService.update(personDTO);
    }
}

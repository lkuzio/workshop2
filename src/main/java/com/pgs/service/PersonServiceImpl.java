package com.pgs.service;

import com.pgs.dto.AddressDTO;
import com.pgs.dto.PersonDTO;
import com.pgs.entity.Address;
import com.pgs.entity.Person;
import com.pgs.mapper.AddressMapper;
import com.pgs.mapper.PersonMapper;
import com.pgs.repository.AddressRepository;
import com.pgs.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<PersonDTO> findAll() {
        return personMapper.toDTO(personRepository.findAll());
    }

    @Override
    public PersonDTO findById(@PathVariable("id") Long id) {
        Person person = personRepository.findById(id);
        if (person != null) {
            return personMapper.toDTO(person);
        }
        throw new EmptyResultDataAccessException(1);
    }

    @Override
    public void add(PersonDTO personDTO) {
        Person saved = personRepository.save(personMapper.toEntity(personDTO));
        List<AddressDTO> addresses = personDTO.getAddresses();
        if (addresses != null) {
            for (AddressDTO addressDTO : addresses) {
                Address address = addressMapper.toEntity(addressDTO);
                address.setPersonId(saved.getId());
                addressRepository.save(address);
            }
        }
    }

    @Override
    public void delete(Long id) {
        personRepository.delete(id);
    }

    @Override
    public void update(PersonDTO personDTO) {
        Person existed = personRepository.findById(personDTO.getId());
        if (existed != null) {
            personRepository.save(personMapper.toEntity(personDTO));
        } else {
            throw new EmptyResultDataAccessException(1);
        }
    }
}

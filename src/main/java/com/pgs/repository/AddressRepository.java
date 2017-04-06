package com.pgs.repository;

import com.pgs.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Luke on 2017-04-06.
 */
@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
    
    List<Address> findAll();
}

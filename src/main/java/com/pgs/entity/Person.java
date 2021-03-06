package com.pgs.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

/**
 * Created by Luke on 2017-04-02.
 */
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Length(min = 2, max = 32)
    private String firstName;

    @NotNull
    @Length(min = 2, max = 32)
    private String lastName;

    @NotNull
    private Date dateOfBirth;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Boolean active;

    @OneToMany(mappedBy = "personId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Address> addresses;

    public Person() {
    }


    public Person(Long id, String firstName, String lastName, Date dateOfBirth, Gender gender, Boolean active) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}

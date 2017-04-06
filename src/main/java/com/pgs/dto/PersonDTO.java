package com.pgs.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

/**
 * Created by Luke on 2017-04-02.
 */
public class PersonDTO {

    private Long id;
    @Length(min = 2)
    private String firstName;
    @Length(min = 2)
    private String lastName;
    @NotNull
    private Date birthday;
    @NotNull
    private String gender;
    private Boolean enabled;
    private List<AddressDTO> address;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<AddressDTO> getAddress() {
        return address;
    }

    public void setAddress(List<AddressDTO> address) {
        this.address = address;
    }
}

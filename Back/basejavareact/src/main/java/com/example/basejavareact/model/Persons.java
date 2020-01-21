package com.example.basejavareact.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Persons
 */
@Entity
public class Persons implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 9065228481115363903L;

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String mail;
    private String sex;
    private Integer idHobbie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getIdHobbie() {
        return idHobbie;
    }

    public void setIdHobbie(Integer idHobbie) {
        this.idHobbie = idHobbie;
    }

}
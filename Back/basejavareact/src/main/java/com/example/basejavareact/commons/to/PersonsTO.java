package com.example.basejavareact.commons.to;

import java.sql.Date;
import java.util.List;
import com.example.basejavareact.model.Hobbies;;

/**
 * PersonsTO
 */
public class PersonsTO extends BaseTO {

    /**
     *
     */
    private static final long serialVersionUID = 8324321294578528875L;

    private String firstName;
    private String lastName;
    private Date birthDate;
    private String mail;
    private String sex;
    private List<Hobbies> hobbies;

    public static long getSerialversionuid() {
        return serialVersionUID;
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

    public List<Hobbies> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobbies> hobbies) {
        this.hobbies = hobbies;
    }

}
package com.example.basejavareact.commons.to;

import java.util.List;

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
    private String birthDate;
    private String mail;
    private String sex;
    private List<HobbiesTO> hobbies;

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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
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

    public List<HobbiesTO> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<HobbiesTO> hobbies) {
        this.hobbies = hobbies;
    }

}
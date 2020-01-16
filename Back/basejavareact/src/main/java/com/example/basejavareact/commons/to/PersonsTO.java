package com.example.basejavareact.commons.to;

/**
 * PersonsTO
 */
public class PersonsTO extends BaseTO {

    /**
     *
     */
    private static final long serialVersionUID = 8324321294578528875L;

    String firstName;
    String lastName;

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

}
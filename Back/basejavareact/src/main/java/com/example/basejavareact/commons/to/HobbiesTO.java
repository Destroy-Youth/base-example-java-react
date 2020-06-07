package com.example.basejavareact.commons.to;

import java.io.Serializable;

/**
 * HobbiesTO
 */
public class HobbiesTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2879232953721356632L;

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
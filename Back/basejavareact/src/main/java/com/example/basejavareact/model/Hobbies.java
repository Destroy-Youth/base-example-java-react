package com.example.basejavareact.model;

import java.io.Serializable;

import javax.persistence.Id;

/**
 * Hobbies
 */
public class Hobbies implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4819239186181304922L;

    @Id
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
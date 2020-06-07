package com.example.basejavareact.commons.to;

import java.io.Serializable;

/**
 * BaseTO
 */
public abstract class BaseTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6146660514296483061L;
    Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
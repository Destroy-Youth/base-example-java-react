package com.example.basejavareact.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.basejavareact.BasejavareactApplication;
import com.example.basejavareact.commons.to.PersonsTO;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

/**
 * ModelMapperTest
 */
public class ModelMapperTest extends BasejavareactApplication {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void PersonEntityToDTO() {

        Persons personEntity = new Persons();
        personEntity.setFirstName("Ivan");
        personEntity.setLastName("Equihua");

        PersonsTO personTO = modelMapper.map(personEntity, PersonsTO.class);
        assertEquals(personTO.getFirstName(), personEntity.getFirstName(), "El nombre es el mismo");
        assertEquals(personTO.getLastName(), personEntity.getLastName(), "El apellido es el mismo");

    }
}
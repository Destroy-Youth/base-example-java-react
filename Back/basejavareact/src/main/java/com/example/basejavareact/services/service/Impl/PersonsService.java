package com.example.basejavareact.services.service.Impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.basejavareact.commons.to.PersonsTO;
import com.example.basejavareact.model.Persons;
import com.example.basejavareact.persistence.IPersonsRepository;
import com.example.basejavareact.services.service.IPersonsService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * PersonsService
 */
public class PersonsService implements IPersonsService {

    @Autowired
    private IPersonsRepository repository;

    @Override
    public List<PersonsTO> findAll() {
        List<Persons> persons = repository.findAll();

        List<PersonsTO> personsTO = persons.stream().map(this::personsTransformer).collect(Collectors.toList());

        return personsTO;
    }

    private PersonsTO personsTransformer(Persons person) {
        PersonsTO personsTO = new PersonsTO();

        personsTO.setId(person.getId());
        personsTO.setFirstName(person.getFirstName());
        personsTO.setLastName(person.getLastName());

        return personsTO;
    }

}
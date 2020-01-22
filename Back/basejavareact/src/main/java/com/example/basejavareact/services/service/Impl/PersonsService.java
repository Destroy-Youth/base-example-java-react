package com.example.basejavareact.services.service.Impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.basejavareact.commons.to.PersonsTO;
import com.example.basejavareact.model.Hobbies;
import com.example.basejavareact.model.Persons;
import com.example.basejavareact.persistence.IPersonsRepository;
import com.example.basejavareact.services.service.IPersonsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

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

    @Override
    public void savePerson(PersonsTO personTO) {
        Persons newPerson = personsTOTransformer(personTO);
        repository.save(newPerson);
    }

    private PersonsTO personsTransformer(Persons person) {
        PersonsTO personsTO = new PersonsTO();

        personsTO.setId(person.getId());
        personsTO.setFirstName(person.getFirstName());
        personsTO.setLastName(person.getLastName());

        return personsTO;
    }

    private Persons personsTOTransformer(PersonsTO personTO) {
        Persons person = new Persons();
        Date birthDate = new Date();
        try {
            birthDate = new SimpleDateFormat("dd-MM-yyyy").parse(personTO.getBirthDate());
        } catch (ParseException e) {
            // TODO Cutom exception invalid date format
            e.printStackTrace();
        }

        person.setFirstName(personTO.getFirstName());
        person.setLastName(personTO.getLastName());
        person.setBirthDate(birthDate);
        person.setMail(personTO.getMail());
        person.setSex(personTO.getSex());

        if (!ObjectUtils.isEmpty(personTO.getHobbies())) {
            List<Hobbies> hobbies = personTO.getHobbies().stream().map(hobbieTO -> {
                Hobbies hobbie = new Hobbies();
                hobbie.setName(hobbieTO.getName());
                return hobbie;
            }).collect(Collectors.toList());
            person.setHobbies(hobbies);
        }

        return person;
    }

}
package com.example.basejavareact.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import com.example.basejavareact.commons.to.PersonsTO;
import com.example.basejavareact.model.Persons;
import com.example.basejavareact.services.service.IPersonsService;
import com.example.basejavareact.util.DTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * PersonsController
 */
@RestController
@CrossOrigin
public class PersonsController {

    @Autowired
    private IPersonsService personsService;

    @GetMapping(consumes = ALL_VALUE, produces = APPLICATION_JSON_VALUE, value = "/v1/persons")
    public ResponseEntity<List<PersonsTO>> persons() {
        return new ResponseEntity<>(personsService.findAll(), HttpStatus.OK);
    }

    @PostMapping(consumes = ALL_VALUE, produces = APPLICATION_JSON_VALUE, value = "/v1/persons")
    public ResponseEntity person(@RequestBody PersonsTO person) {
        personsService.savePerson(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(consumes = ALL_VALUE, produces = APPLICATION_JSON_VALUE, value = "/v1/test/personsDTO")
    public ResponseEntity person(@DTO(PersonsTO.class) Persons person) {
        personsService.savePersonEntity(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

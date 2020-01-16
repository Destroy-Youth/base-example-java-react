package com.example.basejavareact.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import com.example.basejavareact.commons.to.PersonsTO;
import com.example.basejavareact.services.service.IPersonsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * PersonsController
 */
@RestController
public class PersonsController {

    @Autowired
    private IPersonsService personsService;

    @GetMapping(consumes = ALL_VALUE, produces = APPLICATION_JSON_VALUE, value = "/v1/persons")
    public ResponseEntity<List<PersonsTO>> productosPorUbicacionYCodigo() {
        return new ResponseEntity<>(personsService.findAll(), HttpStatus.OK);
    }

}
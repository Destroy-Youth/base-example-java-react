package com.example.basejavareact.services.service;

import java.util.List;

import com.example.basejavareact.commons.to.PersonsTO;

import org.springframework.stereotype.Service;

/**
 * IPersonsService
 */
@Service
public interface IPersonsService {

    List<PersonsTO> findAll();
}
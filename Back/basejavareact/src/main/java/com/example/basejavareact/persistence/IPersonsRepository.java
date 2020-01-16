package com.example.basejavareact.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.basejavareact.model.Persons;

/**
 * PersonsRepository
 */
@Repository
public interface IPersonsRepository extends JpaRepository<Persons, Integer> {

}
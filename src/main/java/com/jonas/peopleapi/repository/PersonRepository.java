package com.jonas.peopleapi.repository;

import java.util.Optional;

import com.jonas.peopleapi.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{
    
    Optional<Person> findByCpf(String cpf);
    
}

package com.jonas.peopleapi.controller;

import java.util.List;

import com.jonas.peopleapi.dto.PersonDTO;
import com.jonas.peopleapi.entity.Person;
import com.jonas.peopleapi.exception.PersonNotFoundException;
import com.jonas.peopleapi.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
    
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public List<PersonDTO> findAll(){
        return personService.findAll();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO createPerson(@RequestBody PersonDTO personDTO){
        return personService.savePerson(personDTO);
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO updatePerson(PersonDTO personDTO) throws PersonNotFoundException{
        return personService.updatePerson(personDTO);
    }

    @DeleteMapping("/{cpf}")
    public String deletePerson(@PathVariable String cpf) throws PersonNotFoundException{
        return personService.deleteByCpf(cpf);
    }

}

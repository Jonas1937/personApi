package com.jonas.peopleapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.jonas.peopleapi.dto.PersonDTO;
import com.jonas.peopleapi.entity.Person;
import com.jonas.peopleapi.exception.PersonNotFoundException;
import com.jonas.peopleapi.mapper.PersonMapper;
import com.jonas.peopleapi.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper;

    @Autowired
    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public List<PersonDTO> findAll(){
        return personRepository.findAll().stream().map(personMapper::toDTO)
            .collect(Collectors.toList());
    }

    public Optional<Person> findOnePersonByCpf(String cpf) throws PersonNotFoundException{
        return checkIfExistsPersonByCpf(cpf);
    }
    
    public PersonDTO savePerson(PersonDTO personDTO){
        personRepository.save(personMapper.toModel(personDTO));
        return personDTO;
    }

    public PersonDTO updatePerson(PersonDTO personDTO) throws PersonNotFoundException{
        checkIfExistsPersonByCpf(personDTO.getCpf());
        personRepository.save(personMapper.toModel(personDTO));
        return personDTO;
    }


    public String deleteByCpf(String cpf) throws PersonNotFoundException{
        checkIfExistsPersonByCpf(cpf);
        return "Person deleted with sucess";
    }

    public Optional<Person> checkIfExistsPersonByCpf(String cpf) throws PersonNotFoundException{
        Optional<Person> findPerson = personRepository.findByCpf(cpf);
        if(!findPerson.isPresent()){
            throw new PersonNotFoundException(cpf);
        } else {
            return findPerson;
        }
    }

}

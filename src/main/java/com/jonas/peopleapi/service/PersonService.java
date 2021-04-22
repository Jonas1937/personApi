package com.jonas.peopleapi.service;

import java.util.List;
import java.util.Optional;

import com.jonas.peopleapi.entity.Person;
import com.jonas.peopleapi.exception.PersonNotFoundException;
import com.jonas.peopleapi.repository.PersonRepository;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Optional<Person> findOnePersonByCpf(String cpf) throws PersonNotFoundException{
        return checkIfExistsPersonByCpf(cpf);
    }
    
    public Person savePerson(Person person){
        return personRepository.save(person);
    }

    public Person updatePerson(Person person) throws PersonNotFoundException{
        checkIfExistsPersonByCpf(person.getCpf());
        return personRepository.save(person);
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

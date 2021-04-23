package com.jonas.peopleapi.service;

import static com.jonas.peopleapi.utils.PersonUtils.createFakeDTO;
import static com.jonas.peopleapi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.jonas.peopleapi.dto.PersonDTO;
import com.jonas.peopleapi.entity.Person;
import com.jonas.peopleapi.mapper.PersonMapper;
import com.jonas.peopleapi.repository.PersonRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    
    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenAPersonDtoThenReturnValidResponse(){
        PersonDTO personDTO = createFakeDTO();
        Person person = createFakeEntity();

        when(personMapper.toModel(personDTO)).thenReturn(person);
        when(personRepository.save(person)).thenReturn(person);

        assertEquals(personService.savePerson(personDTO), personDTO);
    }
}

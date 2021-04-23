package com.jonas.peopleapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import com.jonas.peopleapi.dto.PersonDTO;
import com.jonas.peopleapi.entity.Person;

public class PersonUtils {

    private static final String FIRST_NAME = "Jonas";
    private static final String LAST_NAME = "Silva";
    private static final String CPF_NUMBER = "123.456.789-00";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2002,04,15);

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("04-04-2010")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }




}

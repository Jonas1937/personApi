package com.jonas.peopleapi.exception;

public class PersonNotFoundException extends Exception{

    public PersonNotFoundException(String cpf) {
        super(String.format("Person of CPF: %a not found", cpf));
    }

 
    
}

package com.mongodb.rest.api.services;

import com.mongodb.rest.api.dto.PersonDto;

import java.util.List;

public interface IPersonService {
    public PersonDto createPerson(PersonDto personDto);
    public List<PersonDto> getAllPersons();
    public PersonDto getPerson(String id);
    public Boolean deletePerson(String id);
    public PersonDto updatePerson(String id,PersonDto personDto);
}

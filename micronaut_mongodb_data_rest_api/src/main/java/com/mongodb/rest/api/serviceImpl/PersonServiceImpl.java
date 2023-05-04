package com.mongodb.rest.api.serviceImpl;

import com.mongodb.rest.api.dto.PersonDto;
import com.mongodb.rest.api.entity.Person;
import com.mongodb.rest.api.exceptions.ResourceNotFound;
import com.mongodb.rest.api.mapper.Assembler;
import com.mongodb.rest.api.repository.PersonRepository;
import com.mongodb.rest.api.services.IPersonService;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class PersonServiceImpl implements IPersonService {
    private final PersonRepository personRepository;
    private final Assembler assembler;


    public PersonServiceImpl(PersonRepository personRepository, Assembler assembler) {
        this.personRepository = personRepository;
        this.assembler = assembler;
    }

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        return assembler.mapObject(personRepository.save(assembler.mapObject(personDto, Person.class)),PersonDto.class);
    }

    @Override
    public List<PersonDto> getAllPersons() {
        return assembler.mapList((List<Person>)personRepository.findAll(),PersonDto.class);
    }

    @Override
    public PersonDto getPerson(String id) {
        return assembler.mapObject(personRepository.findById(id).orElseThrow(()->new ResourceNotFound("Person Not Found with : "+id)),PersonDto.class);
    }

    @Override
    public Boolean deletePerson(String id) {
        Person person = personRepository.findById(id).orElseThrow(()->new ResourceNotFound("Person Not Found with : "+id));
        personRepository.delete(person);
        return true;
    }

    @Override
    public PersonDto updatePerson(String id, PersonDto personDto) {
        Person person = personRepository.findById(id).orElseThrow(()->new ResourceNotFound("Person Not Found with : "+id));
        person.setCity(personDto.getCity());
        person.setEmail(personDto.getEmail());
        person.setName(personDto.getName());
        person.setSalary(personDto.getSalary());
        return assembler.mapObject(personRepository.save(person), PersonDto.class);
    }
}

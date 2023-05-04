package micronaut.example.java.techie.services;

import java.util.List;
import micronaut.example.java.techie.dtos.PersonDTO;

public interface PersonService {
    public PersonDTO createPerson(PersonDTO personDTO);
    public PersonDTO findById(Long id);
    public List<PersonDTO> findAll();
    public Boolean deleteById(Long id);
    public PersonDTO updateById(Long id,PersonDTO personDTO);
}

package micronaut.example.java.techie.services.impl;
import jakarta.inject.Singleton;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import micronaut.example.java.techie.dtos.PersonDTO;
import micronaut.example.java.techie.models.Person;
import micronaut.example.java.techie.repository.PersonRepository;
import micronaut.example.java.techie.services.PersonService;
import org.modelmapper.ModelMapper;

@Singleton
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;
    private final  ModelMapper modelMapper;

    public PersonServiceImpl(PersonRepository personRepository, ModelMapper modelMapper) {
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonDTO createPerson(PersonDTO personDTO) {
      Person person = modelMapper.map(personDTO, Person.class);
      return modelMapper.map( personRepository.save(person),PersonDTO.class);
    }

    @Override
    public PersonDTO findById(Long id) {
        Person person = personRepository.findById(id).get();
        return modelMapper.map(person, PersonDTO.class);
    }

    @Override
    public List<PersonDTO> findAll() {
     return personRepository.findAll().stream().map(person -> this.modelMapper.map(person, PersonDTO.class)).collect(Collectors.toList());
    }

    @Override
    public Boolean deleteById(Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if(personOptional.isPresent()){
          personRepository.delete(personOptional.get());
          return true;
        }
        else{
            return false;
        }   
    }

    @Override
    public PersonDTO updateById(Long id, PersonDTO personDTO) {
       Person person = modelMapper.map(personDTO, Person.class);
       person.setId(id);
        return modelMapper.map( personRepository.save(person),PersonDTO.class);
    }


}

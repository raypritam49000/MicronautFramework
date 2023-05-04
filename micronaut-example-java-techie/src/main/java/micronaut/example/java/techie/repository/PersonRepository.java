package micronaut.example.java.techie.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import micronaut.example.java.techie.models.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person,Long>{
}

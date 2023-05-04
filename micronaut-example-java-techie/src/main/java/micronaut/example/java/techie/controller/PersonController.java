package micronaut.example.java.techie.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.Put;
import java.util.Map;
import java.util.NoSuchElementException;
import micronaut.example.java.techie.dtos.PersonDTO;
import micronaut.example.java.techie.services.PersonService;


@Controller("/api/persons")
@Produces(MediaType.APPLICATION_JSON)
public class PersonController {
    
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    
    @Get(uri = "/message")
    public String index() {
        System.out.println(personService);
        return "Hello Pritam Ray";
    }

    @Get(uri="/person/{id}")
    public HttpResponse<?>  getPerson(@PathVariable Long id) {
        try {
            PersonDTO personDTO = personService.findById(id);
            if(personDTO!=null){
                return HttpResponse.status(HttpStatus.OK).status(200).body(Map.of("status","SUCCESS","statusCode",200,"message","Person Details","data",personDTO));
            }
            else{
                return HttpResponse.status(HttpStatus.NOT_FOUND).status(404).body(Map.of("status","SUCCESS","statusCode",404,"message","Person Not Found"));    
            }
             
        } 
        catch(NoSuchElementException e){
             return HttpResponse.status(HttpStatus.NOT_FOUND).status(404).body(Map.of("status","SUCCESS","statusCode",404,"message","Person Not Found"));    
        }
        catch (Exception e) {
             return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).status(501).body(Map.of("status","INTERNAL_SERVER_ERROR","statusCode",501,"message","Server Error"));
       }
    }
    
    @Get(uri="/getAllPersons")
    public HttpResponse<?>  getPersons() {
        try {
             return HttpResponse.status(HttpStatus.OK).status(200).body(Map.of("status","SUCCESS","statusCode",200,"message","Person List Details","data",personService.findAll()));
        } catch (Exception e) {
             return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).status(501).body(Map.of("status","INTERNAL_SERVER_ERROR","statusCode",501,"message","Server Error"));
       }
    }
    
    @Post(uri="/createPerson")
    public HttpResponse<?> savePerson(@Body PersonDTO personDTO) {
       try{
           return HttpResponse.status(HttpStatus.CREATED).status(201).body(Map.of("status","CREATED","statusCode",201,"message","Person has been created","data",personService.createPerson(personDTO)));
       }
       catch(Exception ex){
            return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).status(501).body(Map.of("status","INTERNAL_SERVER_ERROR","statusCode",501,"message","Server Error"));
       }
    }
    
    @Delete(uri="/person/{id}")
    public HttpResponse<?>  deletePerson(@PathVariable Long id) {
        try {
             Boolean isDeleted = personService.deleteById(id);
             if(isDeleted){
               return HttpResponse.status(HttpStatus.OK).status(200).body(Map.of("status","SUCCESS","statusCode",200,"message","Person has been deleted"));
             }
             else{
                   return HttpResponse.status(HttpStatus.NOT_FOUND).status(404).body(Map.of("status","SUCCESS","statusCode",404,"message","Person Not Found"));   
             }
        } catch (Exception e) {
             return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).status(501).body(Map.of("status","INTERNAL_SERVER_ERROR","statusCode",501,"message","Server Error"));
       }
    }
    
    @Put(uri="/updatePerson/{id}")
    public HttpResponse<?> updatePerson(@PathVariable Long id,@Body PersonDTO personDTO) {
       try{
           return HttpResponse.status(HttpStatus.CREATED).status(201).body(Map.of("status","SUCCESS","statusCode",200,"message","Person has been updated","data",personService.updateById(id, personDTO)));
       }
       catch(Exception ex){
            return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).status(501).body(Map.of("status","INTERNAL_SERVER_ERROR","statusCode",501,"message","Server Error"));
       }
    }
    
    
}
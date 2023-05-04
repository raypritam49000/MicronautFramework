package com.mongodb.rest.api.controllers;

import com.mongodb.rest.api.dto.PersonDto;
import com.mongodb.rest.api.services.IPersonService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Controller("/api/v1/persons")
@Tag(name = "Person Controller",description = "Person Rest Api")
@Validated
public class PersonController {

    private IPersonService personService;

    @Inject
    public void setPersonService(IPersonService personService) {
        this.personService = personService;
    }

    @Get(uri="/greetings/{name}", produces= MediaType.TEXT_PLAIN)
    @Operation(summary = "Greets a person",
            description = "A friendly greeting is returned"
    )
    @ApiResponse(
            content = @Content(mediaType = "text/plain",
                    schema = @Schema(type="string"))
    )
    @ApiResponse(responseCode = "400", description = "Invalid Name Supplied")
    @ApiResponse(responseCode = "404", description = "Person not found")
    public String greetings(@Parameter(description="The name of the person") @NotBlank String name) {
        return new String("Hello " + name + ", How are you doing?");
    }

    @Operation(summary = "Get Persons", description = "Returns a persons collection")
    @Get(uri="/", produces= MediaType.APPLICATION_JSON)
    public List<PersonDto> getPersons(){
        return this.personService.getAllPersons();
    }

    @Operation(summary = "Get a Person by its id",description = "find Person By Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Person",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Person not found",
                    content = @Content) })
    @Get(uri="/{id}", produces= MediaType.APPLICATION_JSON)
    public PersonDto getPerson(@Parameter(description = "id of person to be searched")  @PathVariable("id") String id){
        return this.personService.getPerson(id);
    }


    @Operation(summary = "Create Person", description = "This can only be done by the logged in person.")
    @ApiResponses(value = { @ApiResponse(description = "successful operation",
            content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDto.class)),
                    @Content(mediaType = "application/xml", schema = @Schema(implementation = PersonDto.class))
           })
    })
    @Post(value = "/", consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" })
    public PersonDto createPerson(
            @NotNull
            @Parameter(description = "Created Person object", required = true)
            @Valid
            @Body PersonDto personDto){
        return this.personService.createPerson(personDto);
    }

    @Operation(summary = "Update Person", description = "This can only be done by the logged in person.")
    @ApiResponses(value = { @ApiResponse(description = "successful operation",
            content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDto.class)),
                    @Content(mediaType = "application/xml", schema = @Schema(implementation = PersonDto.class))
            })
    })
    @Put(value = "/{id}", consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" })
    public PersonDto updatePerson(@Parameter(description = "id of person to be searched")@PathVariable("id") String id,@Body PersonDto personDto){
        return this.personService.updatePerson(id,personDto);
    }

    @Operation(summary = "Delete a Person by its id",description = "Delete Person By Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the Person",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Map.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Person not found",
                    content = @Content) })
    @Delete(value = "/{id}")
    public Map<String,Object> deletePerson(@Parameter(description = "id of person to be searched")@PathVariable("id") String id){
        return personService.deletePerson(id) ? Map.of("status","success","statusCode",200,"isSuccess",true) : Map.of("status","error","statusCode",500,"isSuccess",false);
    }
}
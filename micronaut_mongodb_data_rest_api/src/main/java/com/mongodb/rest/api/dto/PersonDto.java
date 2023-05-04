package com.mongodb.rest.api.dto;

import javax.validation.constraints.*;

public class PersonDto {
    private String id;
    @NotBlank(message = "name is required")
    @Min(value = 3,message = "name is minimum 3 characters")
    private String name;

    @NotBlank(message = "city is required")
    @Min(value = 3,message = "city is minimum 3 characters")
    private String city;

    @NotBlank(message = "email is required")
    @Email(message = "Please enter a valid email Id")
    private String email;

    @NotBlank(message = "salary is required")
    @Min(value = 3,message = "salary is minimum 3 characters")
    private String salary;

    public PersonDto() {
    }

    public PersonDto(String name, String city, String email, String salary) {
        this.name = name;
        this.city = city;
        this.email = email;
        this.salary = salary;
    }

    public PersonDto(String id, String name, String city, String email, String salary) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.email = email;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}

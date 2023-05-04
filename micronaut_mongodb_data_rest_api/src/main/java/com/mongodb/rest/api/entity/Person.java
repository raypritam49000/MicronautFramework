package com.mongodb.rest.api.entity;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.core.annotation.Introspected;


@Introspected
@MappedEntity
public class Person {
    @Id
    @GeneratedValue(GeneratedValue.Type.UUID)
    private String id;
    private String name;
    private String city;
    private String email;
    private String salary;

    public Person() {
    }

    public Person(String id, String name, String city, String email, String salary) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.email = email;
        this.salary = salary;
    }

    public Person(String name, String city, String email, String salary) {
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
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}

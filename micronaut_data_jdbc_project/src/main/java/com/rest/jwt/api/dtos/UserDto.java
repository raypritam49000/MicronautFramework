package com.rest.jwt.api.dtos;

import io.micronaut.core.annotation.Introspected;
import javax.validation.constraints.NotBlank;

@Introspected
public class UserDto {

    private Long id;
    private String name;
    private String city;
    private String email;
    private String pincode;
    private String state;
    private String country;

    public UserDto() {
    }

    public UserDto(String name, String city, String email, String pincode, String state, String country) {
        this.name = name;
        this.city = city;
        this.email = email;
        this.pincode = pincode;
        this.state = state;
        this.country = country;
    }

    public UserDto(Long id, String name, String city, String email, String pincode, String state, String country) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.email = email;
        this.pincode = pincode;
        this.state = state;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", pincode='" + pincode + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

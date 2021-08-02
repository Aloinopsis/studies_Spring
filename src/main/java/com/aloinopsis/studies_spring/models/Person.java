package com.aloinopsis.studies_spring.models;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@MappedSuperclass
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, message = "Imię musi posiadać minimum 2 znaki")
    private String firstName;

    private String lastName;

    @Min(value = 18, message = "Minimalny wiek to 18 lat")
    private Byte age;

    @Email(message = "Email jest niepoprawny")
    private String mail;
}

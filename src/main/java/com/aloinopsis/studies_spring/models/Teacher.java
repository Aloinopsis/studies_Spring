package com.aloinopsis.studies_spring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Teacher extends Person{

    private String subject;

    @JsonIgnore
    @ManyToMany(mappedBy = "teachers")
    private List<Student> students;
}

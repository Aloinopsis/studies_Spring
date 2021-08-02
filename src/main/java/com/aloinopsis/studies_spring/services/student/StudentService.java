package com.aloinopsis.studies_spring.services.student;

import com.aloinopsis.studies_spring.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();

    Student createStudent(Student student);

    Student updateStudent(Long id, Student toSave);

    Student delStudent(Long id);

    Student getStudent(Long id);

    Page<Student> getStudentsByTeacher(Long teacherId, Pageable pageable);

    Page<Student> getStudentsBySearchEngine(String firstName, String lastName, Pageable pageable);
}

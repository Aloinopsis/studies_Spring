package com.aloinopsis.studies_spring.controllers.rest;

import com.aloinopsis.studies_spring.models.Student;
import com.aloinopsis.studies_spring.services.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/student")
public class StudentRestController {

    final StudentService studentService;

    @GetMapping("search")
    public Page<Student> getStudentsBySearchEngine(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName,
            @PageableDefault(size = 20) Pageable pageable
    ) {
        return studentService.getStudentsBySearchEngine(firstName, lastName, pageable);
    }

    @GetMapping("teacher{/teacherId}")
    public Page<Student> getStudentsByTeacher(
            @PathVariable Long teacherId,
            @PageableDefault(size=20) Pageable pageable
    ){
        return studentService.getStudentsByTeacher(teacherId, pageable);
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @PostMapping
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("{id}")
    public Student updateStudent(@PathVariable Long id, @Valid @RequestBody Student toSave) {
        return studentService.updateStudent(id, toSave);
    }

    @DeleteMapping("{id}")
    public Student delStudent(@PathVariable Long id) {
        return studentService.delStudent(id);
    }
}

package com.aloinopsis.studies_spring.controllers.rest;

import com.aloinopsis.studies_spring.models.Teacher;
import com.aloinopsis.studies_spring.services.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/teacher")
public class TeacherRestController {

    final TeacherService teacherService;

    @GetMapping("search")
    public Page<Teacher> getTeachersBySearchEngine(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName,
            @PageableDefault(size = 20) Pageable pageable
            ) {
        return teacherService.getTeachersBySearchEngine(firstName, lastName, pageable);

    }

    @GetMapping("student{/studentId}")
    public Page<Teacher> getTeachersByStudent(
            @PathVariable Long studentId,
            @PageableDefault(size = 20) Pageable pageable
    ){
        return teacherService.getTeachersByStudent(studentId, pageable);
    }

    @GetMapping
    public List<Teacher> getTeachers() {
        return teacherService.getTeachers();
    }

    @GetMapping("{id}")
    public Teacher getTeacher(@PathVariable Long id) {
        return teacherService.getTeacher(id);
    }

    @PostMapping
    public Teacher createTeacher(@Valid @RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);
    }

    @PutMapping("{id}")
    public Teacher updateTeacher(@PathVariable Long id, @Valid @RequestBody Teacher toSave) {
        return teacherService.updateTeacher(id, toSave);
    }

    @DeleteMapping("{id}")
    public Teacher delTeacher(@PathVariable Long id) {
        return teacherService.delTeacher(id);
    }
}

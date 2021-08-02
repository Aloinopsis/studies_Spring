package com.aloinopsis.studies_spring.services.teacher;

import com.aloinopsis.studies_spring.models.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TeacherService {

    List<Teacher> getTeachers();

    Teacher createTeacher(Teacher teacher);

    Teacher updateTeacher(Long id, Teacher toSave);

    Teacher delTeacher(Long id);

    Teacher getTeacher(Long id);

    Page<Teacher> getTeachersByStudent(Long studentId, Pageable pageable);

    Page<Teacher> getTeachersBySearchEngine(String firstName, String lastName, Pageable pageable);
}

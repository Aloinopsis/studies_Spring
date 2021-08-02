package com.aloinopsis.studies_spring.services.teacher;

import com.aloinopsis.studies_spring.exceptions.UserNotFoundException;
import com.aloinopsis.studies_spring.models.Teacher;
import com.aloinopsis.studies_spring.repositories.TeacherRepository;
import com.aloinopsis.studies_spring.services.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Lazy))
@Service
public class TeacherServiceImpl implements TeacherService{

   final TeacherRepository teacherRepository;
   @Lazy
   final StudentService studentService;


    @Override
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        teacher.setId(null);
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Long id, Teacher toSave) {
        toSave.setId(id);
        return teacherRepository.save(toSave);
    }

    @Override
    public Teacher delTeacher(Long id) {
        var teacher = getTeacher(id);
        teacherRepository.deleteById(id);
        return teacher;
    }

    @Override
    public Teacher getTeacher(Long id) {
        return teacherRepository.findById(id)
             .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public Page<Teacher> getTeachersByStudent(Long studentId, Pageable pageable) {
        return teacherRepository.findAllByStudentId(studentId, pageable);
    }

    @Override
    public Page<Teacher> getTeachersBySearchEngine(String firstName, String lastName, Pageable pageable) {
        if (firstName != null && lastName != null) {
            return teacherRepository.findAllByFirstNameAndLastName(firstName, lastName, pageable);
        }
        if (firstName != null) {
            return teacherRepository.findAllByFirstName(firstName, pageable);
        }
        if (lastName != null) {
            return teacherRepository.findAllByLastName(lastName, pageable);
        }
        return teacherRepository.findAll(pageable);
    }
}


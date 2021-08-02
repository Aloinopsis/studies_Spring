package com.aloinopsis.studies_spring.services.student;

import com.aloinopsis.studies_spring.exceptions.UserNotFoundException;
import com.aloinopsis.studies_spring.models.Student;
import com.aloinopsis.studies_spring.repositories.StudentRepository;
import com.aloinopsis.studies_spring.services.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{

    final StudentRepository studentRepository;
    final TeacherService teacherService;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        student.setId(null);
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }

    @Override
    public Student delStudent(Long id) {
        var student = getStudent(id);
        studentRepository.deleteById(id);
        return student;
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id )
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public Page<Student> getStudentsByTeacher(Long teacherId, Pageable pageable) {
        return studentRepository.findAllByTeacherId(teacherId, pageable);
    }

   @Override
    public Page<Student> getStudentsBySearchEngine(String firstName, String lastName, Pageable pageable) {
        if (firstName != null && lastName != null) {
            return studentRepository.findAllByFirstNameAndLastName(firstName, lastName, pageable);
        }
        if (firstName != null) {
            return studentRepository.findAllByFirstName(firstName, pageable);
        }
        if (lastName != null) {
            return studentRepository.findAllByLastName(lastName, pageable);
        }
        return studentRepository.findAll(pageable);
    }
}


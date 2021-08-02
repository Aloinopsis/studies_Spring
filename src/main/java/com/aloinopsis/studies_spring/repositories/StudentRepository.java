package com.aloinopsis.studies_spring.repositories;

import com.aloinopsis.studies_spring.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Page<Student> findAll(Pageable pageable);
    Page<Student> findAllByFirstName(String firstName, Pageable pageable);
    Page<Student> findAllByLastName(String  lastName, Pageable pageable);
    Page<Student> findAllByFirstNameAndLastName(String firstName, String lastName, Pageable pageable);

@Query("select s from Student s join s.teachers t where t.id = :teacherId")
    Page<Student>findAllByTeacherId(
            @Param("teacherId") Long teacherId, Pageable pageable);

}

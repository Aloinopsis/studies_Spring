package com.aloinopsis.studies_spring.repositories;

import com.aloinopsis.studies_spring.models.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Page<Teacher> findAll(Pageable pageable);
    Page<Teacher> findAllByFirstName(String firstName, Pageable pageable);
    Page<Teacher> findAllByLastName(String  lastName, Pageable pageable);
    Page<Teacher> findAllByFirstNameAndLastName(String firstName, String lastName, Pageable pageable);

    @Query("select t from Teacher t join t.students s where s.id = :studentId")
    Page<Teacher> findAllByStudentId(
            @Param("studentId") Long studentId, Pageable pageable);
}

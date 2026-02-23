package com.example.PracticeSBProject.repository;

import com.example.PracticeSBProject.dto.StudentClassEntity;
import com.example.PracticeSBProject.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> findBySectionAndName(String section,String name);

    @Query("Select s FROM Student s where s.roll_number = ?1")
    List<Student> findByRollNumber(@Param("roll_number") Integer roll);

    @Query("Select s FROM Student s where s.roll_number < :roll_number")
    List<Student> findByRollDesc(@Param("roll_number") Integer roll);

    @Query("Select s.name,count(s) from Student s group by s.name")
    List<Object[]> findCountOfStudentBySection();

    @Query(value = "select * from student",nativeQuery = true)
    Page<Student> findAllStudents(Pageable pageable);

    //Projection
    @Query("select new com.example.PracticeSBProject.dto.StudentClassEntity(s.which_class,"+" Count(s)) from Student s group by s.which_class")
    List<StudentClassEntity> findStudentsClass();

}

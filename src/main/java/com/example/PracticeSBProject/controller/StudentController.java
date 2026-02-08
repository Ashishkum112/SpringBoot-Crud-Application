package com.example.PracticeSBProject.controller;

import com.example.PracticeSBProject.dto.Student;
import com.example.PracticeSBProject.exception.ResourceNotFoundException;
import com.example.PracticeSBProject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController
{

    private final StudentService studentService;


    @PostMapping
    public ResponseEntity<Student> createUser(@RequestBody Student student)
    {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Student> updateUser(@RequestBody Student student,@PathVariable Integer id)
    {
        Student updatedStudent = studentService.updateStudent(student,id);
        if (updatedStudent == null)
        {
            throw new IllegalArgumentException("Student ID with : " +id +" Not Found,Please give a valid id");
        }
        return ResponseEntity.ok(updatedStudent);
    }


    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents()
    {
        List<Student> students = studentService.getAllStudent();
        if (students.isEmpty())
        {
            throw new ResourceNotFoundException("There are no students,Please create a student using post Method ");
        }
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id)
    {
        Student student = studentService.getStudentById(id);
        if (student == null)
        {
            throw new IllegalArgumentException("Student ID with : " +id +" Not Found,Please give a valid id");
        }
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStudentById(@PathVariable Integer id)
    {
        boolean isDeleted = studentService.deleteStudent(id);
        if (!isDeleted)
        {
            throw new IllegalArgumentException("Student ID with : " +id +" Not Found,Please give a valid id");
        }
        return ResponseEntity.noContent().build();
    }



}

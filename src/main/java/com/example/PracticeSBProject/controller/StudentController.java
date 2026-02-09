package com.example.PracticeSBProject.controller;

import com.example.PracticeSBProject.dto.StudentDto;
import com.example.PracticeSBProject.exception.ResourceNotFoundException;
import com.example.PracticeSBProject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController
{

    private final StudentService studentService;


    @PostMapping
    public ResponseEntity<StudentDto> createUser(@RequestBody StudentDto student)
    {
        StudentDto createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateUser(@RequestBody StudentDto student, @PathVariable Integer id)
    {
        StudentDto updatedStudent = studentService.updateStudent(student,id);
        if (updatedStudent == null)
        {
            throw new IllegalArgumentException("Student ID with : " +id +" Not Found,Please give a valid id");
        }
        return ResponseEntity.ok(updatedStudent);
    }


    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents()
    {
        List<StudentDto> students = studentService.getAllStudent();
        if (students.isEmpty())
        {
            throw new ResourceNotFoundException("There are no students,Please create a student using post Method ");
        }
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Integer id)
    {
        StudentDto student = studentService.getStudentById(id);
        if (student == null)
        {
            throw new IllegalArgumentException("Student ID with : " +id +" Not Found,Please give a valid id");
        }
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Integer id)
    {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }



}

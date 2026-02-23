package com.example.PracticeSBProject;


import com.example.PracticeSBProject.entity.Student;
import com.example.PracticeSBProject.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class StudentTest {




    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void studentTestCases(){
        Page<Student> studentsPage = studentRepository.findAll(PageRequest.of(0,2, Sort.by("name")));




        for (Student student : studentsPage)
        {
            System.out.println(student);
        }
    }
}

package com.example.PracticeSBProject.service;

import com.example.PracticeSBProject.dto.Student;
import com.example.PracticeSBProject.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    private Map<Integer,Student> studentDb = new HashMap<>();


//    public List<Student> getAllStudents() {
//        return ;
//    }
    //Create
    public Student createStudent(Student student) {

        studentDb.putIfAbsent(student.getId(),student);
        return student;
    }

    //GetAll
    public List<Student> getAllStudent()
    {
        return new ArrayList<>(studentDb.values());
    }

    //GetByID
    public Student getStudentById(Integer id)
    {
        if (!studentDb.containsKey(id))
        {
            return null;
        }
        return studentDb.get(id);
    }
    //Update User
    public Student updateStudent(Student student,Integer id)
    {
        if (!studentDb.containsKey(id))
        {
            throw new ResourceNotFoundException("User with Id "+ id + " Doesn't Exist,Please Give Correct Id");
        }
        studentDb.put(id,student);
        return student;
    }



    //Delete
    public boolean deleteStudent(Integer id)
    {
        if (!studentDb.containsKey(id))
        {
            throw new ResourceNotFoundException("User with Id "+ id + " Doesn't Exist,Please Give Correct Id");
        }

        studentDb.remove(id);
        return true;
    }
    //TODO : Create a implement Service Class

}

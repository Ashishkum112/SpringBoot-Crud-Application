package com.example.PracticeSBProject.service;

import com.example.PracticeSBProject.dto.StudentDto;
import com.example.PracticeSBProject.entity.Student;
import com.example.PracticeSBProject.exception.ResourceNotFoundException;
import com.example.PracticeSBProject.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

//    Without Database We can use this
//    private Map<Integer, StudentDto> studentDb = new HashMap<>();

    //Create
    public StudentDto createStudent(StudentDto student) {
        Student studentEntity = new Student();

        studentEntity.setName(student.getName());
        studentEntity.setSection(student.getSection());
        studentEntity.setRoll_number(student.getRoll_number());
        studentEntity.setWhich_class(student.getWhich_class());

        Student savedStudent = studentRepository.save(studentEntity);

        return mapToDTO(savedStudent);

    }

    //GetAll
    public List<StudentDto> getAllStudent()
    {
        List<Student> studentList = new ArrayList<>(studentRepository.findAll());
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (Student student : studentList)
        {
            studentDtoList.add(mapToDTO(student));
        }
        return studentDtoList;
    }

    //GetByID
    public StudentDto getStudentById(Integer id)
    {
        Student student = studentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException
                        ("User with Id "+ id + " Doesn't Exist,Please Give Correct Id"));


        return mapToDTO(student);
    }
    //Update User
    public StudentDto updateStudent(StudentDto studentDto, Integer id)
    {
        Student student = studentRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("User not found with : " +id));

        student.setName(studentDto.getName());
        student.setSection(studentDto.getSection());
        student.setWhich_class(studentDto.getWhich_class());
        student.setRoll_number(studentDto.getRoll_number());



        studentRepository.save(student);

        return mapToDTO(student);
    }



    //Delete
    public void deleteStudent(Integer id)
    {
        Student student = studentRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("User with Id "+ id + " Doesn't Exist,Please Give Correct Id"));
        studentRepository.delete(student);

    }

    //Create a mapper method to map the enity to Dto
    private StudentDto mapToDTO(Student student)
    {
        return new StudentDto(
                student.getId(),
                student.getName(),
                student.getRoll_number(),
                student.getWhich_class(),
                student.getSection()
        );

    }




    //TODO : Create a implement Service Class

}

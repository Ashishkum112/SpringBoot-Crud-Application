package com.example.PracticeSBProject;

import com.example.PracticeSBProject.dto.StudentClassEntity;
import com.example.PracticeSBProject.entity.Student;
import com.example.PracticeSBProject.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@RequiredArgsConstructor
class PracticeSbProjectApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testQueryMethods() {
//		List<Student> students = studentRepository.findBySectionAndName("P","Ashish Kuma");

//		for (Student student : students)
//		{
//			System.out.println(student);
//		}

//		List<Student> studentsWithRoll = studentRepository.findByRollNumber(12);

//		for (Student student : studentsWithRoll)
//		{
//			System.out.println(student);
//		}

//		List<Student> studentWithRollLessThan40  = studentRepository.findByRollDesc(20);

//		for(Student student : studentWithRollLessThan40)
//		{
//			System.out.println(student);
//		}

//		List<Object[]> findCountStudentBySection = studentRepository.findCountOfStudentBySection();

//		for (Object[] student : findCountStudentBySection)
		{
//			System.out.println(student[0] + " " +  student[1]);
//		}
//
//			List<Student> studentList = studentRepository.findAllStudents();
//			for (Student student : studentList) {
//				System.out.println(student);
//			}

//			List<StudentClassEntity> countStudentByClass = studentRepository.findStudentsClass();
//
//			for (StudentClassEntity studentClassEntity : countStudentByClass)
//			{
//				System.out.println(studentClassEntity);
//			}
		}
	}


}

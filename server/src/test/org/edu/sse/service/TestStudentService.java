package org.edu.sse.service;

import java.util.List;

import org.edu.sse.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml"})
public class TestStudentService {

	@Autowired
	StudentService studentService;
	
	@Test
	public void getStudentList(){
		List<Student> students = studentService.getStudentList();
		
		for(Student student : students){
			System.out.println(student.getAdmission().getFirstName());
		}
	}
	
}

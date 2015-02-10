package org.edu.sse.service;

import java.util.List;

import org.edu.sse.dao.StudentDAO;
import org.edu.sse.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class StudentService {
	
	@Autowired
	StudentDAO studentDAO;
	
	public List<Student> getStudentList(){
		return studentDAO.getList();
	}
	
	public void saveorUpdate(Student student){
		studentDAO.saveOrUpdate(student);
	}
	
	public void saveOrUpdateAll(List<Student> studentList){
		for(Student student : studentList){
			saveorUpdate(student);
		}
	}

}

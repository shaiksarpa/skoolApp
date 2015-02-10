package org.edu.sse.dao;

import org.edu.sse.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO extends BaseDAO<Student> {

	@Override
	protected Class<Student> getDomainClass() {
		return Student.class;
	}

}

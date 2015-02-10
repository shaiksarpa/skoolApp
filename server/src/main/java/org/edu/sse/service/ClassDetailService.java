package org.edu.sse.service;

import java.util.List;

import org.edu.sse.dao.ClassDetailDAO;
import org.edu.sse.model.ClassDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ClassDetailService {

	@Autowired
	private ClassDetailDAO classDetailDAO;

	public List<ClassDetail> getListOfClasses() {
		List<ClassDetail> classList = classDetailDAO.getList();
		return classList;
	}

	public ClassDetail findById(Long id) {
		return classDetailDAO.get(id);
	}

	public ClassDetail findByName(String className) {
		return classDetailDAO.findByName(className);
	}

	public int getCount() {
		return classDetailDAO.count();
	}
}

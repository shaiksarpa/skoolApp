package org.edu.sse.service;

import java.util.List;

import org.edu.sse.dao.AdmissionDAO;
import org.edu.sse.model.Admission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AdmissionService {

	@Autowired
	AdmissionDAO admissionDAO;

	public List<Admission> getAdmissionList() {
		return admissionDAO.getList();
	}

	public Long save(Admission admission) {
		admissionDAO.save(admission);
		return admission.getPid();
	}

	public int count() {
		return admissionDAO.count();
	}

	public Admission findByAdmission(String admissionNo) {
		return admissionDAO.findByAdmission(admissionNo);
	}

}

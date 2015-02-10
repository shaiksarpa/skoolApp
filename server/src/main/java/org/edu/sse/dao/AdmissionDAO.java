package org.edu.sse.dao;

import org.edu.sse.model.Admission;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class AdmissionDAO extends BaseDAO<Admission> {

	@Override
	protected Class<Admission> getDomainClass() {
		return Admission.class;
	}

	public Admission findByAdmission(String admissionNo) {
		Query query = getSession().getNamedQuery(Admission.FINDBY_ADMISSIONID_NQUERY);
		query.setString("admissionId", admissionNo);
		Admission admission = (Admission) query.uniqueResult();
		return admission;
	}
}

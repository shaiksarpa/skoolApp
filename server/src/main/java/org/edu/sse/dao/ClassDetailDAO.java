package org.edu.sse.dao;

import org.edu.sse.model.ClassDetail;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ClassDetailDAO extends BaseDAO<ClassDetail> {

	@Override
	protected Class<ClassDetail> getDomainClass() {
		return ClassDetail.class;
	}

	public ClassDetail findByName(String className) {
		Criteria criteria = getSession().createCriteria(ClassDetail.class);
		criteria.add(Restrictions.eq("className", className));
		return (ClassDetail) criteria.uniqueResult();
	}

}

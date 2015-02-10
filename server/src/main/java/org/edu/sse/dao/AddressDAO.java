package org.edu.sse.dao;

import org.edu.sse.model.Address;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAO extends BaseDAO<Address>{

	@Override
	protected Class<Address> getDomainClass() {
		return Address.class;
	}

}

package org.edu.sse.service;

import org.edu.sse.dao.AddressDAO;
import org.edu.sse.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AddressService {
	
	@Autowired
	AddressDAO addressDAO;
	
	public Address findById(Long id){
		return addressDAO.get(id);
	}
	
	public void save(Address address){
		addressDAO.save(address);
	}
}

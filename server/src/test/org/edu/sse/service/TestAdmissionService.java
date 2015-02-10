package org.edu.sse.service;

import java.util.List;

import org.edu.sse.model.Admission;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml"})
public class TestAdmissionService {
	
	@Autowired
	AdmissionService admissionService;
	
	@Test
	public void testListofAdmission(){
		List<Admission> admissions = admissionService.getAdmissionList();
		Assert.assertNotNull(admissions);
	}
	
	@Test
	public void testNamedQueries(){
		Admission admission = admissionService.findByAdmission("1753");
		Assert.assertNotNull(admission);
		Assert.assertEquals("Admission found", "1753", admission.getAdmissionId());
	}
	

}

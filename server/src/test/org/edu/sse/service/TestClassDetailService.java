package org.edu.sse.service;

import junit.framework.Assert;

import org.edu.sse.model.ClassDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml"})
public class TestClassDetailService {
	
	@Autowired
	ClassDetailService classDetailService;
	
	@Test
	public void testGetListOfClasses(){

		Assert.assertEquals(classDetailService.getListOfClasses().size(),classDetailService.getCount());
	}
	
	@Test
	public void testFindByName(){
		ClassDetail classDetail = classDetailService.findByName("VI");
		Assert.assertEquals(classDetail.getClassName(), "VI");
	}
}

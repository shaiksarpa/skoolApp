package org.edu.sse.entityconversion;

import java.io.IOException;

import org.edu.sse.model.ClassDetail;
import org.edu.sse.service.ClassDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class ClassDetailEntityConversion extends JsonDeserializer<ClassDetail>{

	@Autowired
	ClassDetailService classDetailService;
	
	public ClassDetailEntityConversion(){
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	@Override
	public ClassDetail deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		 JsonNode node = jp.getCodec().readTree(jp);
		 if(null!=node){
			 return classDetailService.findById(node.asLong());
		 } else {
			 return new ClassDetail();
		 }
		
	}

}

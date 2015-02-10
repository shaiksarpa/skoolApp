package org.edu.sse.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.edu.sse.dto.AdmissionDto;
import org.edu.sse.dto.StudentCSV;
import org.edu.sse.dto.StudentDto;
import org.edu.sse.model.Address;
import org.edu.sse.model.Admission;
import org.edu.sse.model.ClassDetail;
import org.edu.sse.model.Student;
import org.edu.sse.service.AddressService;
import org.edu.sse.service.AdmissionService;
import org.edu.sse.service.ClassDetailService;
import org.edu.sse.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

@Controller
public class AdmissionController {

	@Autowired
	AdmissionService admissionService;

	@Autowired
	ClassDetailService classDetailService;

	@Autowired
	AddressService addressService;

	@Autowired
	StudentService studentService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/admission")
	public AdmissionDto showAdmissionPage(ModelMap model) {
		AdmissionDto admissionDto = new AdmissionDto();
		admissionDto.setClassDetails(classDetailService.getListOfClasses());

		return admissionDto;
	}

	@RequestMapping(value = "addStudent", method = RequestMethod.POST)
	@ResponseBody
	public Admission addStudent(@RequestBody Admission admission) {
		admission.setAdmissionId("SSE" + admissionService.count());
		admissionService.save(admission);
		return admission;
	}

	@RequestMapping(value = "classList")
	@ResponseBody
	public List<ClassDetail> getClassDetails() {
		return classDetailService.getListOfClasses();
	}

	@RequestMapping(value = "fileUpload")
	@ResponseBody
	public List<StudentDto> uploadStudentDetails(@RequestParam("file") MultipartFile multipart) {
		List<StudentDto> studentList = new ArrayList<StudentDto>();
		if (!multipart.isEmpty()) {
			File convFile = new File(multipart.getOriginalFilename());
			try {
				multipart.transferTo(convFile);
				CsvToBean<StudentCSV> csvToBean = new CsvToBean<StudentCSV>();
				CSVReader csvReader = new CSVReader(new FileReader(convFile),',','\'',1);
				List<StudentCSV> studentCSVList = csvToBean.parse(setColumMapping(), csvReader);
				for(StudentCSV studentCSV : studentCSVList){
					Student student = new Student(); 
					Admission admission = admissionService.findByAdmission(studentCSV.getAdmissionNo());
					if(admission == null){
						admission = new Admission();
						admission.setAdmissionId(studentCSV.getAdmissionNo());
						admission.setFirstName(studentCSV.getName());
						Address address = new Address();
						address.setPhone(Long.valueOf(studentCSV.getPhone()));
						address.setVillage(studentCSV.getVillage());
						admissionService.save(admission);
						addressService.save(address);
						student.setAddress(address);
						student.setAdmission(admission);
						student.setClassDetail(classDetailService.findByName(studentCSV.getClassName()));
						studentService.saveorUpdate(student);
						StudentDto studentDto = new StudentDto();
						BeanUtils.copyProperties(student, studentDto);
						studentDto.setCode("SUCCESS");
						studentDto.setMessage("Successfully Admission inserted "+admission.getAdmissionId());
					} else {
						StudentDto studentDto = new StudentDto();
						studentDto.setAdmission(admission);
						studentDto.setCode("DUPLICATE");
						studentDto.setMessage("Duplicate Admission "+admission.getAdmissionId());
						studentList.add(studentDto);
					}
				}
				csvReader.close();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch(Exception e){
				e.printStackTrace();
			} finally{
				convFile.delete();
			}
		}
		return studentList;
	}

	private ColumnPositionMappingStrategy<StudentCSV> setColumMapping() {
		ColumnPositionMappingStrategy<StudentCSV> strategy = new ColumnPositionMappingStrategy<StudentCSV>();
		strategy.setType(StudentCSV.class);
		String[] columns = new String[] { "admissionNo", "name", "className","phone", "village" };
		strategy.setColumnMapping(columns);
		return strategy;
	}
}

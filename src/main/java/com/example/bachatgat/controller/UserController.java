package com.example.bachatgat.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bachatgat.entities.User;
import com.example.bachatgat.repository.UserRepository;
import com.example.bachatgat.service.UserService;
import com.example.bachatgat.util.ExcelGenerator;
import com.example.bachatgat.util.ExcelImport;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getExcel")
	public String exportExcel(HttpServletResponse response)throws IOException{
		response.setContentType("application/octet-stream");
		String headerKey="Content-Disposition";
		String headerValue="attachment;filename=Bachatgat.xlsx";
		response.setHeader(headerKey, headerValue);
		List<User> users=userRepository.findAll();
		ExcelGenerator excelGenerator=new ExcelGenerator(users);
		excelGenerator.generateExcelFile(response);
		return "coverted successfuly";
	}
	
	@PostMapping()
	public String postData(@RequestBody User user)  {
		userService.postAllData(user);
		return "posted";
	}
	
	@PostMapping("/addExcel")
	public String importExcel() throws FileNotFoundException {
		ExcelImport importE =new ExcelImport();
		List<User> workers=importE.ExcelImport();
		userRepository.saveAll(workers);
		return "done";
		
	}
	
}

package com.schoology.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schoology.service.StudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "students", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class StudentController {

	private StudentService service;

	@GetMapping("/first-name")
	public List<String> autoComplete(@RequestParam(name = "first-name", required = false) String firstName){
		return service.autoCompleteFirstName(firstName);
	}
}

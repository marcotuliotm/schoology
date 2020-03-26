package com.schoology.service;

import static com.schoology.domain.Student.STUDENT_FIRST_NAME_CACHE;

import java.util.Collections;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.schoology.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {
	private static final int MIN_LENGTH = 3;
	private StudentRepository repository;

	@Cacheable(value = STUDENT_FIRST_NAME_CACHE, condition = "#firstName!=null and #firstName.length() >= " + MIN_LENGTH)
	public List<String> autoCompleteFirstName(String firstName) {
		if (Strings.isNullOrEmpty(firstName) || firstName.length() < MIN_LENGTH) {
			return Collections.emptyList();
		}
		return repository.findFirstsNameByFirstName(firstName);
	}
}

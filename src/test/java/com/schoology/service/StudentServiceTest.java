package com.schoology.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.schoology.repository.StudentRepository;


public class StudentServiceTest {

	protected static final List<String> NAMES = Arrays.asList("Mary", "Mario");
	protected static final String FILTER = "Mar";

	@InjectMocks
	private StudentService service;

	@Mock
	private StudentRepository repository;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		when(repository.findFirstsNameByFirstName(FILTER)).thenReturn(NAMES);
	}

	@Test
	public void shouldBeEqualsNames() {
		assertEquals(NAMES, service.autoCompleteFirstName(FILTER));
		verify(repository).findFirstsNameByFirstName(anyString());
		verifyNoMoreInteractions(repository);
	}

	@Test
	public void shouldBeEmpty() {
		assertEquals(Collections.EMPTY_LIST, service.autoCompleteFirstName("12"));
		verifyNoMoreInteractions(repository);
	}
}
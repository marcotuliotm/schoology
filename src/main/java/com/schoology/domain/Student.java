package com.schoology.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.schoology.dto.Gender;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@NamedQueries({
		@NamedQuery(name = Student.STUDENT_AUTOCOMPLETE, query =
				"select distinct student.firstName from Student student where UPPER(student.firstName) like UPPER(CONCAT(:firstName,'%')) order by student.firstName "),
})
public class Student {

	protected static final String STUDENT = "Student";
	protected static final String STUDENT_AUTOCOMPLETE = STUDENT + ".findFirstsNameByFirstName";
	public static final String STUDENT_FIRST_NAME_CACHE = STUDENT + ".firstName";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	@Size(max = 50)
	private String firstName;
	@NotEmpty
	@Size(max = 50)
	private String lastName;
	@Email
	@NotEmpty
	@Size(max = 50)
	private String email;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Gender gender;
}

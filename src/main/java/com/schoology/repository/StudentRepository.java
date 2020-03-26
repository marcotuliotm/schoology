package com.schoology.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.schoology.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	@Query(name = "Student.findFirstsNameByFirstName")
	List<String> findFirstsNameByFirstName(@Param("firstName") String firstName);
}

package com.vp.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vp.model.Student;

@Repository
public class StudentDao {

	private final JdbcTemplate jdbcTemplate;

	public StudentDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// CREATE
	public int save(Student s) {
		String sql = """
				INSERT INTO students (name, email, course)
				VALUES (?, ?, ?)
				""";

		return jdbcTemplate.update(sql, s.getName(), s.getEmail(), s.getCourse());
	}

	// READ ALL
	public List<Student> findAll() {
		String sql = "SELECT * FROM students";

		return jdbcTemplate.query(sql, (rs, rowNum) -> new Student(rs.getInt("id"), rs.getString("name"),
				rs.getString("email"), rs.getString("course")));
	}

	// READ BY ID
	public Student findById(int id) {
		String sql = "SELECT * FROM students WHERE id = ?";

		List<Student> students = jdbcTemplate.query(sql, (rs, rowNum) -> new Student(rs.getInt("id"),
				rs.getString("name"), rs.getString("email"), rs.getString("course")), id);

		return students.isEmpty() ? null : students.get(0);
	}

	// UPDATE
	public int update(Student s) {
		String sql = """
				UPDATE students
				SET name = ?, email = ?, course = ?
				WHERE id = ?
				""";

		return jdbcTemplate.update(sql, s.getName(), s.getEmail(), s.getCourse(), s.getId());
	}

	// DELETE
	public int delete(int id) {
		String sql = "DELETE FROM students WHERE id = ?";

		return jdbcTemplate.update(sql, id);
	}
}
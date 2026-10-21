package com.vp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vp.dao.StudentDao;
import com.vp.model.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

	
	 @Autowired
	 private final StudentDao studentDao;

	    public StudentController(StudentDao studentDao) {
	        this.studentDao = studentDao;
	    }

	    // CREATE
	    @PostMapping
	    public String save(@RequestBody Student student) {
	        studentDao.save(student);
	        return "Student saved successfully";
	    }

	    // READ ALL
	    @GetMapping
	    public List<Student> getAll() {
	        return studentDao.findAll();
	    }

	    // READ BY ID
	    @GetMapping("/{id}")
	    public Student getById(@PathVariable int id) {
	        return studentDao.findById(id);
	    }

	    // UPDATE
	    @PutMapping("/{id}")
	    public String update(
	            @PathVariable int id,
	            @RequestBody Student student) {

	        student.setId(id);

	        int rows = studentDao.update(student);

	        return rows > 0
	            ? "Student updated successfully"
	            : "Student not found";
	    }

	    // DELETE
	    @DeleteMapping("/{id}")
	    public String delete(@PathVariable int id) {
	        int rows = studentDao.delete(id);

	        return rows > 0
	            ? "Student deleted successfully"
	            : "Student not found";
	    }
	}





package com.vp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

package org.example.repository;

import org.example.model.Employee;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findById(Long aLong);

    List<Employee> findByName(String name);

    Optional<Employee> findByCpf(String cpf);
}


package org.example.repository;

import org.example.model.Employee;
import org.example.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findById(Long aLong);

    List<Employee> findByName(String name);

    Optional<Employee> findByCpf(String cpf);

    List<Employee> findAll();

    List<Employee> findByRole(Roles roles);
}


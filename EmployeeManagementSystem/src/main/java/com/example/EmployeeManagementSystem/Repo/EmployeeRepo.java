package com.example.EmployeeManagementSystem.Repo;
import com.example.EmployeeManagementSystem.Entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRepo extends MongoRepository<Employee, String> {
}
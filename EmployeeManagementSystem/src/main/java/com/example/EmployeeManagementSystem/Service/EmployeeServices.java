package com.example.EmployeeManagementSystem.Service;
import com.example.EmployeeManagementSystem.Entity.Employee;
import com.example.EmployeeManagementSystem.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepo repo;

    public void saveorUpdate(Employee employee) {
        repo.save(employee);
    }

    public Iterable<Employee> listAll() {
        return this.repo.findAll();
    }

    public void deleteEmployee(String id) {
        repo.deleteById(id);
    }

    public Employee getEmployeeByID(String employeeId) {
        return repo.findById(employeeId).get();
    }
}
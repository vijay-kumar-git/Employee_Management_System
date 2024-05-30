package com.example.EmployeeManagementSystem.Controller;
import com.example.EmployeeManagementSystem.Entity.Employee;
import com.example.EmployeeManagementSystem.Service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    @PostMapping(value = "/save")
    private String saveEmployee(@RequestBody Employee employee) {
        employeeServices.saveorUpdate(employee);
        return employee.get_id();
    }
    
    @GetMapping(value = "/getall")
    public Iterable<Employee> getEmployees() {
        return employeeServices.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    private Employee update(@RequestBody Employee employee, @PathVariable(name = "id") String _id) {
        employee.set_id(_id);
        employeeServices.saveorUpdate(employee);
        return employee;
    }

    @DeleteMapping("/delete/{id}")
    private void deleteEmployee(@PathVariable("id") String _id) {
        employeeServices.deleteEmployee(_id);
    }

    @RequestMapping("/search/{id}")
    private Employee getEmployee(@PathVariable(name = "id") String employeeId) {
        return employeeServices.getEmployeeByID(employeeId);
    }
}
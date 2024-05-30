package com.example.EmployeeManagementSystem.Entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="employees")
public class Employee {

    @Id
    private String _id;
    private String employeename;
    private String employeeaddress;
    private String mobile;

    public Employee(String _id, String employeename, String employeeaddress, String mobile) {
        this._id = _id;
        this.employeename = employeename;
        this.employeeaddress = employeeaddress;
        this.mobile = mobile;
    }

    public Employee() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getEmployeeaddress() {
        return employeeaddress;
    }

    public void setEmployeeaddress(String employeeaddress) {
        this.employeeaddress = employeeaddress;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "_id='" + _id + '\'' +
                ", employeename='" + employeename + '\'' +
                ", employeeaddress='" + employeeaddress + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
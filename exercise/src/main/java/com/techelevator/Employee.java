package com.techelevator;

import java.time.LocalDate;

public class Employee {
    private long employeeId;
    private String firstName;

    private String lastName;
    private String email;
    private double salary;
    private Department department;
    private LocalDate hireDate;

    public long getEmployeeId() { return employeeId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public Department getDepartment() { return department; }
    public LocalDate getHireDate() { return hireDate; }
    public double getSalary() { return salary; }

    public void setEmployeeId(long employeeId) { this.employeeId = employeeId; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setDepartment(Department department) { this.department = department; }
    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }

    static final double STARTING_SALARY = 60000;

    public Employee() {}

    public Employee(long employeeId, String firstName, String lastName, String email, Department department, LocalDate hireDate) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salary = STARTING_SALARY;
        this.department = department;
        this.hireDate = hireDate;
    }

    public String getFullName() {
        return lastName + ", " + firstName;
    }

    public void raiseSalary(double percent) {
        salary += (percent / 100) * salary;
    }
}

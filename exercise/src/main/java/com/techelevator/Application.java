package com.techelevator;

import javax.swing.*;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public List<Department> departments = new ArrayList<>();
    public List<Employee> employees = new ArrayList<>();
    public Map<String, Project> projects = new HashMap<>();

    /**
     * The main entry point in the application
     * @param args
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private Department getDepartmentByName(String name){
        Department correctDepartment = null;
        for (Department department: departments) {
            if (department.getName().equals(name)){
            correctDepartment = department;
            }
        }
        return correctDepartment;
    }


    private void run() {
        // create some departments
        createDepartments();
//        createDepartments(1, "Marketing");
//        createDepartments(2, "Sales");
//        createDepartments(3, "Engineering");

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!
        employees.get(1).raiseSalary(10);

        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();
        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();
    }

    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {
//        Department department = new Department(departmentId, name);
//        departments.add(department);
        Department marketing = new Department(1, "Marketing");
        departments.add(marketing);
        Department sales = new Department(2, "Sales");
        departments.add(sales);
        Department engineering = new Department(3, "Engineering");
        departments.add(engineering);
    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        for (Department department : departments) {
            System.out.println(department.getName());
        }
    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {
        LocalDate today = LocalDate.now();
        Employee deanJohnson = new Employee();
        deanJohnson.setEmployeeId(1);
        deanJohnson.setFirstName("Dean");
        deanJohnson.setLastName("Johnson");
        deanJohnson.setEmail("djohnson@teams.com");
        deanJohnson.setSalary(60000);
        deanJohnson.setDepartment(getDepartmentByName("Engineering"));
        deanJohnson.setHireDate(today);
        employees.add(deanJohnson);
        Employee angieSmith = new Employee(2, "Angie", "Smith", "asmith@teams.com", getDepartmentByName("Engineering"), today);
        employees.add(angieSmith);
        Employee margaretThompson = new Employee(3, "Margaret", "Thompson", "mthompson@teams.com", getDepartmentByName("Marketing"), today);
        employees.add(margaretThompson);
    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("\n------------- EMPLOYEES ------------------------------");
        for (Employee employee : employees) {
            System.out.println(employee.getFullName() + " (" + currency.format(employee.getSalary()) + ") " + employee.getDepartment().getName() + ", " + employee.getHireDate());
        }
    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {
        Project teamsPms = new Project("TEams", "Project Management Software",LocalDate.now(),LocalDate.now().plusDays(30));
        for (Employee employee : employees) {
            if (employee.getDepartment().getName().equals("Engineering")) {
                teamsPms.getTeamMembers().add(employee);
            }
        }
        projects.put("TEams", teamsPms);
    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {
        Project marketingLp = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing", LocalDate.now().plusDays(31), LocalDate.now().plusDays(38));
        for (Employee employee : employees) {
            if (employee.getDepartment().getName().equals("Marketing")) {
                marketingLp.getTeamMembers().add(employee);
            }
        }
        projects.put("Marketing Landing Page", marketingLp);
    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        for (Map.Entry<String, Project> project : projects.entrySet()) {
            System.out.println(project.getKey() + ": " + project.getValue().getTeamMembers().size());
            System.out.println("Start Date: " + project.getValue().getStartDate() + ", Due Date: " + project.getValue().getDueDate());
        }
    }

}

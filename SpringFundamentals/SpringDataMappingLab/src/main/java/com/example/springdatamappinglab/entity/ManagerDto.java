package com.example.springdatamappinglab.entity;


import java.util.Set;

public class ManagerDto {
    private String firstName;
    private String lastName;
    private Set<Employee> employees;

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
            builder.append(String.format("%s %s | Employees: %d",this.firstName,this.lastName,this.employees.size())).append(System.lineSeparator());
            this.employees.stream().forEach(e->builder.append(e).append(System.lineSeparator()));
        return builder.toString().trim();
    }
}

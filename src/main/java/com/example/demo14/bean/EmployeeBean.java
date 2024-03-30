package com.example.demo14.bean;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class EmployeeBean {
    private List<String> employeeNames;

    public EmployeeBean() {
        // Dummy data for demonstration
        employeeNames = new ArrayList<>();
        employeeNames.add("Alice");
        employeeNames.add("Bob");
        employeeNames.add("Charlie");
    }

    public List<String> getEmployeeNames() {
        return employeeNames;
    }
}

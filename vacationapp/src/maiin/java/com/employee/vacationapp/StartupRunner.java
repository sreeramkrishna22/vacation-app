package com.employee.vacationapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StartupRunner implements CommandLineRunner {
    private List<Employee> employees = new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            employees.add(new HourlyEmployee());
            employees.add(new SalariedEmployee());
            employees.add(new Manager());
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

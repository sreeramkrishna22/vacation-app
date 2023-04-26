package com.employee.vacationapp;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private StartupRunner startupRunner;

    public EmployeeController(StartupRunner startupRunner) {
        this.startupRunner = startupRunner;
    }

    @GetMapping("")
    public List<Employee> getEmployees() {
        return startupRunner.getEmployees();
    }

    @PostMapping("/{id}/work")
    public void work(@PathVariable int id, @RequestBody int days) {
        Employee employee = startupRunner.getEmployees().get(id);
        employee.work(days);
    }

    @PostMapping("/{id}/takeVacation")
    public void takeVacation(@PathVariable int id, @RequestBody float days) {
        Employee employee = startupRunner.getEmployees().get(id);
        employee.takeVacation(days);
    }
}
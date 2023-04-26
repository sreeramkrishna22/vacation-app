package com.employee.vacationapp;

public class HourlyEmployee extends Employee {
    @Override
    protected float getVacationDaysPerWorkYear() {
        return 10;
    }
}

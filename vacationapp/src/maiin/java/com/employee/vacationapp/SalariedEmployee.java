package com.employee.vacationapp;

public class SalariedEmployee extends Employee {
    @Override
    protected float getVacationDaysPerWorkYear() {
        return 15;
    }
}

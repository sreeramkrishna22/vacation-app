package com.employee.vacationapp;

public class Manager extends SalariedEmployee {
    @Override
    protected float getVacationDaysPerWorkYear() {
        return 30;
    }
}

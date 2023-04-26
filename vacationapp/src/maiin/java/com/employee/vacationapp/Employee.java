package com.employee.vacationapp;

public abstract class Employee {
    private final int workYearDays = 260;
    private float vacationDays = 0;

    public float getVacationDays() {
        return vacationDays;
    }

    public void work(int days) {
        if (days < 0 || days > workYearDays) {
            throw new IllegalArgumentException("Invalid number of days worked");
        }
        vacationDays += getVacationDaysPerWorkYear() * days / workYearDays;
    }

    public void takeVacation(float days) {
        if (days < 0 || days > vacationDays) {
            throw new IllegalArgumentException("Invalid number of vacation days taken");
        }
        vacationDays -= days;
    }

    protected abstract float getVacationDaysPerWorkYear();
}


import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


interface Employee {
  vacationDays: number;
}

export class AppComponent {
  employees: Employee[] = [];
  daysWorked: number[] = Array(30).fill(0);
  daysTaken: number[] = Array(30).fill(0);

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get<Employee[]>('/api/employees').subscribe((employees) => {
      this.employees = employees;
    });
  }

  getEmployeeType(index: number): string {
    if (index < 10) {
      return 'Hourly Employee';
    } else if (index < 20) {
      return 'Salaried Employee';
    } else {
      return 'Manager';
    }
  }

  work(index: number): void {
    const days = this.daysWorked[index];
    const employee = this.employees[index];
    if (days > 0 && days <= 260) {
      const remainingVacationDays = 260 - days;
      if (employee.vacationDays <= remainingVacationDays) {
        employee.vacationDays += 10;
        this.daysWorked[index] = 0;
        this.http.post(`/api/employees/${index}/work`, days).subscribe();
      }
    }
  }

  takeVacation(index: number): void {
    const days = this.daysTaken[index];
    const employee = this.employees[index];
    if (days > 0 && days <= employee.vacationDays) {
      employee.vacationDays -= days;
      this.daysTaken[index] = 0;
      this.http.post(`/api/employees/${index}/takeVacation`, days).subscribe();
    }
  }
}

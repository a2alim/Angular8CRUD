import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();
  submitted = false;

  constructor(
    private employeeService: EmployeeService,
    private router: Router,
    private toastr: ToastrService
  ) { }

  ngOnInit() {
  }

  newEmployee(): void {
    this.submitted = false;
    this.employee = new Employee();
  }

  save() {
    this.employeeService.createEmployee(this.employee).subscribe(
      (res: any) => {
        if (res.success) {
          this.toastr.success(res.message);
          this.employee = new Employee();
          this.gotoList();
        }
      },
      error => {
        console.log(error)
      }
    );
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/employees']);
  }
}

import { EmployeeDetailsComponent } from './../employee-details/employee-details.component';
import { Observable } from "rxjs";
import { EmployeeService } from "./../employee.service";
import { Employee } from "./../employee";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: "app-employee-list",
  templateUrl: "./employee-list.component.html",
  styleUrls: ["./employee-list.component.css"]
})
export class EmployeeListComponent implements OnInit {
  employees: Observable<Employee[]>;

  constructor(
    private employeeService: EmployeeService,
    private router: Router,
    private toastr: ToastrService
  ) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.employees = this.employeeService.getEmployeesList();
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteEmployee(id).subscribe(
      (res: any) => {
        if (res.success) {
          this.toastr.success(res.message);
          this.reloadData();
        }
      },
      error => console.log(error)
    );
  }

  employeeDetails(id: number) {
    this.router.navigate(['details', id]);
  }

  updateEmployee(emp: number) {
    this.router.navigate(['update', { 'emp': JSON.stringify(emp) }]);
  }
}

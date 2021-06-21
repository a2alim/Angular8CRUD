import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  id: number;
  submitted: number;
  employee: Employee  = new Employee();

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private employeeService: EmployeeService,
    private toastr: ToastrService
  ) { }

  ngOnInit() {
    this.employee = this.route.snapshot.params.emp ? JSON.parse(this.route.snapshot.params.emp): {};
  }

  onSubmit() {
    this.employeeService.updateEmployee(this.employee).subscribe(
      (res: any) => {
        if(res.success){
          this.toastr.success(res.message);
          this.employee = new Employee();
          this.router.navigate(['/employees']);
        }
      },
      error => {
        this.toastr.warning(error.toString());
        console.log(error)
      }
    );
  }
}
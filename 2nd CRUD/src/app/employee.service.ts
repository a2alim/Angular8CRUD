import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = 'http://localhost:8081';

  constructor(private http: HttpClient) { }

  createEmployee(employee: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + '/save-ms-user', employee).pipe(map(data => data));
  }

  updateEmployee(value: any): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + '/update-ms-user', value).pipe(map(data => data));
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + '/delete-ms-user/' + id).pipe(map(data => data));
  }

  getEmployeesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}` + '/show-ms-user');
  }

}

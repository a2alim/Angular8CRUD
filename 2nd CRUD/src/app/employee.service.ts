import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = 'http://localhost:8081';

  constructor(private http: HttpClient) { }

  getEmployee(id: number): Observable<any> {
    return this.http.get('http://localhost:8081/show-ms-user-by/' + id);
  }

  createEmployee(employee: Object): Observable<Object> {
    return this.http.post('http://localhost:8081/save-ms-user', employee);
  }

  updateEmployee(id: number, value: any): Observable<Object> {
    return this.http.put('http://localhost:8081/update-ms-user/' + id, value);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete('http://localhost:8081/delete-ms-user/' + id, { responseType: 'text' });
  }

  getEmployeesList(): Observable<any> {
    return this.http.get('http://localhost:8081/show-ms-user');
  }
}

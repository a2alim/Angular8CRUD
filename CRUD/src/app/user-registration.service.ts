import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {

  constructor(private hhtp: HttpClient) { }

  public doRegistration(user) {
      return this.hhtp.post('http://localhost:8081/save-ms-user', user, {responseType: 'text' as 'json'});
  }

  public getAllUsers() {
    return this.hhtp.get('http://localhost:8081/show-ms-user');
  }

  public getUserByUsename(userName) {
    return this.hhtp.get('http://localhost:8081/show-ms-user-by-username/' + userName);
  }

  public deleteUserById(id) {
    return this.hhtp.get('http://localhost:8081/delete-ms-user/' + id);
  }
}

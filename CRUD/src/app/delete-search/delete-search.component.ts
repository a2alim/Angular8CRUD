import { Component, OnInit } from '@angular/core';
import { UserRegistrationService } from '../user-registration.service';

@Component({
  selector: 'app-delete-search',
  templateUrl: './delete-search.component.html',
  styleUrls: ['./delete-search.component.css']
})
export class DeleteSearchComponent implements OnInit {

  users: any;
  userName: string;

  constructor(private service: UserRegistrationService) { }

  public deleteUser(id: number) {
    const resp = this.service.deleteUserById(id);
    resp.subscribe((data) => this.users = data);
  }

  public searchUserbyUsername(userName) {
    const resp = this.service.getUserByUsename(this.userName);
    resp.subscribe((data) => this.users = data);
  }



  ngOnInit() {
    const resp = this.service.getAllUsers();
    resp.subscribe((data) => this.users = data);
    console.log(this.users);
  }

}

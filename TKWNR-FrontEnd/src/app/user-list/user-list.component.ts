import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from "rxjs";
import { UserService } from '../user.service'
import { User } from '../user'

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: Observable<User[]> | undefined;

  constructor(private router: Router, private userService: UserService) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.users = this.userService.getUsersList();
  }

  deleteUser(username: string) {
    this.userService.deleteUser(username)
    .subscribe(
      data => {
        console.log(data);
        this.reloadData();
      }
    )
  }

  userDetails(username: string) {
    this.router.navigate(['user-details', username])
  }

  updateUser(username: string) {
    this.router.navigate(['user-update', username])
  }

}

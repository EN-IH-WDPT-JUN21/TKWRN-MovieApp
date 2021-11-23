import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html',
  styleUrls: ['./user-update.component.css']
})
export class UserUpdateComponent implements OnInit {

  username!: string;
  user!: User;

  constructor(private userService: UserService, private router: Router, private route: ActivatedRoute) { 
    // this.user = {
    //   username: this.route.snapshot.params['username'],
    //   email: this.route.snapshot.params['email'],
    //   password: this.route.snapshot.params['password'],
    //   userType: this.route.snapshot.params['userType']
    // }
  }

  ngOnInit() {
    this.user = new User();

    this.username = this.route.snapshot.params['username'];

    this.userService.getUser(this.username)
      .subscribe(data => {
        console.log(data)
        this.user = data;
      }, error => console.log(error))
  }

  updateUser() {
    this.userService.updateUser(this.username, this.user)
      .subscribe(data => {
        console.log(data);
        this.user = new User();
        this.goToList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateUser();
  }
 
  goToList() {
    this.router.navigate(['user-details', this.username])
  }

}

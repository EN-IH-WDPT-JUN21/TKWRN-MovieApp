import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from "rxjs";
import { UserService } from '../user.service'
import { User } from '../user'

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  username!: string;
  user!: User;
  avatarURL!: string | null;

  constructor(
    private userService: UserService, 
    private router: Router, 
    private route: ActivatedRoute) { }

  ngOnInit() {
    this.user = new User();

    this.username = this.route.snapshot.params['username'];

    this.userService.getUser(this.username)
      .subscribe(data => {
        console.log(data)
        this.user = data;
      }, error => console.log(error))
  }

  list() {
    this.router.navigate(['users']);
  }

  // deleteUser(username: string) {
  //   this.userService.deleteUser(username)
  //   .subscribe(
  //     data => {
  //       console.log(data);
  //       this.list();
  //     }
  //   )
  // }

  updateUser(username: string) {
    this.router.navigate(['user-update', username])
  }

  getAvatarURL():any {
    if(localStorage.getItem('avatarURL') !== null) {
      this.avatarURL = localStorage.getItem('avatarURL')!.slice(localStorage.getItem('avatarURL')!.length -5);
    } else {
      this.avatarURL = "0.png"
    }
    return this.avatarURL;
  }

}

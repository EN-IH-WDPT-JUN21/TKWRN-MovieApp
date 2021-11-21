import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  user!: User;
  username: string;
  avatarURL!: string | null;
  
  constructor(private auth: AuthService, private userService: UserService) {
    this.username = '';
    // this.user = this.userService.getUser(this.username);

  //   this.userService.getUser(this.username)
  //   .subscribe(data => {
  //     this.user = data;
  //  }, error => console.log(error));
  }
  getAvatarURL():any {
    if(localStorage.getItem('avatarURL') != null) {
      this.avatarURL = localStorage.getItem('avatarURL')!.slice(localStorage.getItem('avatarURL')!.length -5);
    } else {
      this.avatarURL = "7.png"
    }
    return this.avatarURL;
  }

  // checkIfNull() {
  //   if(this.getAvatarURL()!.slice(this.getAvatarURL()!.length -5) != null) {
  //     this.avatarURL = this.getAvatarURL()!.slice(this.getAvatarURL()!.length -5);
  //     return this.avatarURL;
  //   } else {
  //     this.avatarURL = "src/assets/images/7.png" 
  //   }
  //   return this.avatarURL;
  // }
  // avatarURL = this.getAvatarURL()!.slice(this.getAvatarURL()!.length -5);
  
  ngOnInit(): void {
  }

}

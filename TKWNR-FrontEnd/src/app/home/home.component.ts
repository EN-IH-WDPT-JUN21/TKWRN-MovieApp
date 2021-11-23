import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
  // username!: string;
  avatarURL!: string | null;
  
  constructor(private auth: AuthService, private userService: UserService, private router: Router) {}

  getAvatarURL():any {
    if(localStorage.getItem('avatarURL') !== null) {
      this.avatarURL = localStorage.getItem('avatarURL')!.slice(localStorage.getItem('avatarURL')!.length -5);
    } else {
      this.avatarURL = "0.png"
    }
    return this.avatarURL;
  }

  username = localStorage.getItem('username')!;
  
  ngOnInit(): void {
  }

}

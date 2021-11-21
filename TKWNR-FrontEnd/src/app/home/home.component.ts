import { Component, ElementRef, OnInit, ViewChild, Inject } from '@angular/core';
import { AuthService } from '../auth.service';
import { User } from '../user';
import { UserService } from '../user.service';
import { DOCUMENT } from '@angular/common'; 

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  @ViewChild('avatar') avatar!: ElementRef;

  user!: User;
  username!: string;
  avatarURL!: string | null;
  
  constructor(private auth: AuthService, private userService: UserService, @Inject(DOCUMENT) document: any) {
    document.getElementById('avatar')
  }
  getAvatarURL():any {
    if(localStorage.getItem('avatarURL') != null) {
      this.avatarURL = localStorage.getItem('avatarURL')!.slice(localStorage.getItem('avatarURL')!.length -5);
    } else {
      this.avatarURL = "0.png"
    }
    return this.avatarURL;
  }
  
  ngOnInit(): void {
  }

  show(): void {

  }

}

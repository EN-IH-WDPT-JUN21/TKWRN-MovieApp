import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css'],
})
export class LogoutComponent implements OnInit {
  submitted = false;
  wrong = false;
  isLoggedIn = false;

  user: User;

  users!: Observable<User[]>;

  constructor(
    private userService: UserService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
    this.user = {
      username: '',
      email: '',
      password: '',
      userType: '',
    };
  }

  ngOnInit(): void {
    this.user = new User();
    this.isLogged();
  }

  isLogged(): boolean {
    if (localStorage.getItem('username')) {
      return true;
    } else {
      return false;
    }
  }

  logout(): void {
    localStorage.removeItem('username');
    localStorage.removeItem('role');
    this.isLogged();
    console.log(this.isLoggedIn);
    console.log(localStorage);
    this.submitted = false;
    this.wrong = false;
    this.goToHome();
  }

  login(): void {
    this.router.navigate(['/login']);
  }

  goToHome(): void {
    this.router.navigate(['']);
  }
}

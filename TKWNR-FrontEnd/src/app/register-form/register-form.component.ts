import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {

  user: User;

  @ViewChild('form')
  form!: NgForm;

  submitted = false;

  constructor(
    private userService: UserService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
    this.user = {
      username: '',
      email: '',
      password: '',
      bio:'',
      userType: ''
    }
  }

  ngOnInit(): void {
  }

  newUser(): void {
    this.submitted = false;
    this.user = new User();
  }

  save() {
    this.userService
    .createUser(this.user).subscribe(data => {
      console.log(data)
      this.user = new User();
    },
    error => console.log(error));
  }

  checkUserExists(): boolean {
    let exist=false;
    this.userService.getUser(this.form.value.username)
    .subscribe(data => {
      console.log(data);
      exist=true;
      this.submitted = false;
      window.alert('Username exists. Try register with different username');
    }, error => {
      console.log(error);
      exist=false;
      this.save();
      this.submitted = true;
    });
    return exist;
  }


  onSubmit(): void {
    this.submitted = false;
    console.log(this.form.value);
    this.checkUserExists();

  }

  goToLogin(): void {
    this.router.navigate(['/login']);
  }

}

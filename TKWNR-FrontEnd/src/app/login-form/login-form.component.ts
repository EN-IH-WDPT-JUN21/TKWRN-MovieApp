import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  @ViewChild('form')
  form!: NgForm;

  submitted = false;
  wrong = false;

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
      role: ''

    }

  }

  ngOnInit(): void {
    this.user = new User();
    this.reloadData();
  }

  reloadData() {
    this.users=this.userService.getUsersList();
  }


  getUser(username:String): void {
    this.submitted = false;
    this.userService.getUser(this.form.value.username)
    .subscribe(data => {
      console.log(data)
      if(data == null){
        this.submitted=false;
          this.wrong=true;
      }
      this.user = data;

      if(this.user.password === this.form.value.password){
        this.submitted=true;
      }else{
        this.submitted=false;
        this.wrong=true;
      }
    }, error => console.log(error));


  }

  onLogin(): void {
    this.submitted=false;
    this.wrong=true;
    console.log(this.form.value);
    console.log(this.form.value.username);
    if(this.form.value.username)
    this.getUser(this.form.value.username); 

  }

  sendToRegister(): void {
    this.router.navigate(['/register']);
  }



}

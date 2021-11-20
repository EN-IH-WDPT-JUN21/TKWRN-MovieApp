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

  /*checkUserExists(): boolean {
    this.userService.getUser(this.form.value.username)
    .subscribe(data => {
      this.user = data;


    }, error => console.log(error));
    console.log(this.user);
    if(this.user!=null){      
      window.alert('user exists');
      console.log((this.user.email))
      return true;

    }else{          
      console.log('ok');
      return false;
    }
    




  }*/


  onSubmit(): void {
    this.submitted = true;
    console.log(this.form.value);
    /*if(this.checkUserExists()!=true){*/
      this.save();
    /*}else{
      this.submitted = false;
    }*/

  }

  goToLogin(): void {
    this.router.navigate(['/login']);
  }

}

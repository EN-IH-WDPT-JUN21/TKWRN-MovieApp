import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  isLoggedIn(): Boolean{
    if (localStorage.getItem('username')) {
      return true;

    }else{
      return false;
    }

  }

  isAdmin(): Boolean{
    if (localStorage.getItem('role')=='ADMIN') {
      return true;

    }else{
      return false;
    }

  }

}

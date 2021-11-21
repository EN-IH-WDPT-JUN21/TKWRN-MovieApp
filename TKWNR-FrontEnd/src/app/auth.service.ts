import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  isLoggedIn(): boolean{
    if (localStorage.getItem('username')) {
      return true;

    }else{
      return false;
    }

  }

  isAdmin(): boolean{
    if (localStorage.getItem('role')=='ADMIN') {
      return true;

    }else{
      return false;
    }

  }

}

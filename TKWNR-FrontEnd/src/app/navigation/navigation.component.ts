import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  isCollapsed = false;
  isLoggedIn = false;
  isAdmin = false;
  
  constructor(private auth:AuthService) {
    this.isLoggedIn = auth.isLoggedIn();
    this.isAdmin = auth.isAdmin();
   }

  ngOnInit(): void {
  }

}

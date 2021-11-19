import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { RegisterFormComponent } from './register-form/register-form.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserUpdateComponent } from './user-update/user-update.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'login',
    component: HomeComponent,
    children: [
      { path: '', component: LoginFormComponent }
    ]
  },
  {
    path: 'register',
    component: HomeComponent,
    children: [
      { path: '', component: RegisterFormComponent }
    ]
  },
  {
    path: 'users',
    component: HomeComponent,
    children: [
      { path: '', component: UserListComponent }
    ]
  },
  {
    path: 'user-details/:username',
    component: HomeComponent,
    children: [
      { path: '', component: UserDetailsComponent }
    ]
  },
  {
    path: 'user-update/:username',
    component: HomeComponent,
    children: [
      { path: '', component: UserUpdateComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

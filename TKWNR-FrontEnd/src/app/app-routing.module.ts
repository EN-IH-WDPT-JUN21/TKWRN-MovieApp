import { PersonDetailsComponent } from './person-details/person-details.component';
import { MovieDetailsComponent } from './movie-details/movie-details.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { RegisterFormComponent } from './register-form/register-form.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserUpdateComponent } from './user-update/user-update.component';
import { SearchComponent } from './search/search.component';

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
    path: 'movie/:id',
    component: HomeComponent,
    children: [
      { path: '', component: MovieDetailsComponent }
    ]
  },
  {
    path: 'person/:id',
    component: HomeComponent,
    children: [
      { path: '', component: PersonDetailsComponent }
    ]
  },
  {
    path: 'search',
    component: HomeComponent,
    children: [
      { path: '', component: SearchComponent }
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

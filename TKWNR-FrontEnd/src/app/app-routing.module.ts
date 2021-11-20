import { PersonDetailsComponent } from './person-details/person-details.component';
import { MovieDetailsComponent } from './movie-details/movie-details.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { RegisterFormComponent } from './register-form/register-form.component';
import { PlaylistArrayComponent } from './playlist-array/playlist-array.component';
import { PlaylistMovieComponent } from './playlist-movie/playlist-movie.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserUpdateComponent } from './user-update/user-update.component';
import { SearchComponent } from './search/search.component';
import { SearchResultsComponent } from './search-results/search-results.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGuard } from './auth.guard';
import { Auth2Guard } from './auth2.guard';


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
    path: 'logout',
    component: HomeComponent,
    children: [
      { path: '', component: LogoutComponent }
    ]
  },
  {
    path: 'playlists',
    children: [
      { path: '', component: PlaylistArrayComponent }
    ],
    canActivate: [AuthGuard]
  },
    {
    path: 'playlists/:playlistId',
    component: PlaylistMovieComponent,
    canActivate: [AuthGuard]
},
{
    path: 'movie-detail',
    component: MovieDetailsComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'search',
    component: SearchComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'movie/:id',
    component: HomeComponent,
    children: [
      { path: '', component: MovieDetailsComponent }
    ],
    canActivate: [AuthGuard]
  },
  {
    path: 'person/:id',
    component: HomeComponent,
    children: [
      { path: '', component: PersonDetailsComponent }
    ],
    canActivate: [AuthGuard]
  },
  {
    path: 'search-results',
    component: HomeComponent,
    children: [
      { path: '', component: SearchResultsComponent }
    ],
    canActivate: [AuthGuard]
  },
  {
    path: 'users',
    component: HomeComponent,
    children: [
      { path: '', component: UserListComponent }
    ],
    canActivate: [Auth2Guard]
  },
  {
    path: 'user-details/:username',
    component: HomeComponent,
    children: [
      { path: '', component: UserDetailsComponent }
    ],
    canActivate: [AuthGuard]
  },
  {
    path: 'user-update/:username',
    component: HomeComponent,
    children: [
      { path: '', component: UserUpdateComponent }
    ],
    canActivate: [AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

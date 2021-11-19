import { MovieDetailsComponent } from './movie-details/movie-details.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { RegisterFormComponent } from './register-form/register-form.component';
import { PlaylistArrayComponent } from './playlist-array/playlist-array.component';
import { PlaylistMovieComponent } from './playlist-movie/playlist-movie.component';
import { SearchComponent } from './search/search.component';


const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'login',
    component: LoginFormComponent
  },
  {
    path: 'register',
    component: RegisterFormComponent
  },
  {
    path: 'playlists',
    component: PlaylistArrayComponent
  },
    {
    path: 'playlists/:playlistId',
    component: PlaylistMovieComponent
},
{
    path: 'movie-detail',
    component: MovieDetailsComponent
  },
  {
    path: 'search',
    component: SearchComponent

  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule} from '@angular/material/menu';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { RegisterFormComponent } from './register-form/register-form.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { PlaylistArrayComponent } from './playlist-array/playlist-array.component';
import { PlaylistDetailComponent } from './playlist-detail/playlist-detail.component';
import { PlaylistMovieComponent } from './playlist-movie/playlist-movie.component';
import { NavigationComponent } from './navigation/navigation.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UserUpdateComponent } from './user-update/user-update.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MovieDetailsComponent } from './movie-details/movie-details.component';
import { SearchComponent } from './search/search.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SearchResultsComponent } from './search-results/search-results.component';
import { PersonDetailsComponent } from './person-details/person-details.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthService } from './auth.service';



@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
    RegisterFormComponent,
    HomeComponent,
    FooterComponent,
    PlaylistArrayComponent,
    PlaylistDetailComponent,
    PlaylistMovieComponent,
    NavigationComponent,
    UserListComponent,
    UserDetailsComponent,
    UserUpdateComponent,
    MovieDetailsComponent,
    SearchComponent,
    SearchResultsComponent,
    PersonDetailsComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatMenuModule,
    MatMenuModule,
    NgbModule
  ],

  exports:[MatIconModule],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }

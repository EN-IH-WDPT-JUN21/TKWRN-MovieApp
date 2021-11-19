import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from './movie';

@Injectable({
  providedIn: 'root'
})

export class MovieService {

  private baseUrl = 'http://localhost:8100/api/movies';

  constructor(private http: HttpClient) { }

  getMovie(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/get/${id}`);
  }

  getAllMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>(`${this.baseUrl}`);
  }

  getMovieByTitle(title: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/get?title=title`);
  }

  saveMovie(movie: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/new`, movie);
  }

  deleteMoviet(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' });
  }

}

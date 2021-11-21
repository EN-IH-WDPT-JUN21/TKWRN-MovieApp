import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable, Output, EventEmitter } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  @Output() public searchSignal = new EventEmitter();

  private baseURL = "http://localhost:8400/api/search";

  constructor(private http:HttpClient) { }

  searchMade(searchType:string, titleType:string, searchString:string){
    this.searchSignal.emit(searchType + "/" + titleType + "/" + searchString);
  }

  getMovieDetail(id: number): Observable<any>{
    return this.http.get(`${this.baseURL}/title/${id}`);
  }

  getMovieOrSeriesSearchResult(type: string, name: string): Observable<any>{
    return this.http.get(`${this.baseURL}/title/${type}/${name}`);
  }

  getPersonDetail(id: number): Observable<any>{
    return this.http.get(`${this.baseURL}/personId/${id}`);
  }

  getPersonSearchResult(name: string): Observable<any>{
    return this.http.get(`${this.baseURL}/person/${name}`);
  }

  getPopularMovies(): Observable<any>{
    return this.http.get(`${this.baseURL}/popular/movies`);
  }

  getPopularSeries(): Observable<any>{
    return this.http.get(`${this.baseURL}/popular/series`);
  }
}

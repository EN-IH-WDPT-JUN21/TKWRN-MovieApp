import { TitleSearchResult } from './models/title-search-result.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  private baseURL = "http://localhost:8400/api/search";

  constructor(private http:HttpClient) { }

  getMovieDetail(id: number): Observable<any>{
    return this.http.get(`${this.baseURL}/title/${id}`);
  }

  getMovieOrSeriesSearchResult(type: string, name: string): Observable<any>{
    return this.http.get(`${this.baseURL}/title/${type}/${name}`);
  }

  getPersonDetail(id: number): Observable<any>{
    return this.http.get(`${this.baseURL}/person/${id}`);
  }

  getPersonSearchResultDetail(name: string): Observable<any>{
    return this.http.get(`${this.baseURL}/person/${name}`);
  }
}

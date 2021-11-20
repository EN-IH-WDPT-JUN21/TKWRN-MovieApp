import { TitleSearchResult } from './models/title-search-result.model';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MovieStorageService {

  movie: TitleSearchResult = new TitleSearchResult("null", "null", "null", "null");

  constructor() { }

  public setMovie(movie:TitleSearchResult){
    this.movie = movie;
  }

  public getMovie():TitleSearchResult{
    var movieHolder = this.movie;
    this.movie = new TitleSearchResult("null", "null", "null", "null");
    return movieHolder;
  }
}

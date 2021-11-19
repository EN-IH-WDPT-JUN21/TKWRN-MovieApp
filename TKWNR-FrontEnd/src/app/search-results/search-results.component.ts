
import { Star } from './../models/star.model';
import { Router } from '@angular/router';
import { SearchService } from './../search.service';
import { TitleSearchResult } from './../models/title-search-result.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'movie-list',
  templateUrl: './search-results.component.html',
  styleUrls: ['./search-results.component.css']
})
export class SearchResultsComponent implements OnInit {

  movieList: TitleSearchResult[] = []
  personList: Star[] = []
  searchType: string;
  titleType: string;
  searchString: string;

  constructor(private searchService: SearchService) {
    this.searchType = "";
    this.titleType = "";
    this.searchString = "";
  }

  ngOnInit(): void {
    //For testing purposes
    this.movieList.push(new TitleSearchResult(
      "tt0110413", 
      "https://m.media-amazon.com/images/M/MV5BODllNWE0MmEtYjUwZi00ZjY3LThmNmQtZjZlMjI2YTZjYmQ0XkEyXkFqcGdeQXVyNTc1NTQxODI@._V1_Ratio0.6791_AL_.jpg",
      "Léon: The Professional", 
      "1994"))
  }

  performSearch(searchType: string, titleType: string, searchString:string): void {
    if (searchType.toLocaleLowerCase() == "movies"){
      this.searchService.getMovieOrSeriesSearchResult(titleType, searchString)
      .subscribe(data => {
        this.movieList = data;
        this.personList = [];
      }, error => console.log(error))
    } else {
      this.searchService.getPersonSearchResultDetail(this.searchString)
      .subscribe(data => {
        this.personList = data;
        this.movieList = [];
      }, error => console.log(error))
    }
  }

  openMenu():void {
    
  }


}
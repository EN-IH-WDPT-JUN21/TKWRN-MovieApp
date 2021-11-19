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


}

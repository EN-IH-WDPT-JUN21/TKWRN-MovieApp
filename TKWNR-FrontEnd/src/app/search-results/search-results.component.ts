import { PopularSearchResult } from './../models/popular.model';
import { MovieStorageService } from './../movie-storage.service';
import { NameSearchResult } from './../models/name-search-result.model';

import { Router } from '@angular/router';
import { SearchService } from './../search.service';
import { TitleSearchResult } from '../models/title-search-result';
import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { Subscription } from 'rxjs';

@Component({
  selector: 'movie-list',
  templateUrl: './search-results.component.html',
  styleUrls: ['./search-results.component.css']
})
export class SearchResultsComponent implements OnInit {

  movieList: TitleSearchResult[] = [];
  personList: NameSearchResult[] = [];
  popularMoviesList: PopularSearchResult[] = [];
  popularSeriesList: PopularSearchResult[] = [];
  searchType: string;
  titleType: string;
  searchString: string;

  private subscription!: Subscription;

  constructor(public searchService: SearchService, public router: Router, public playListStorage:MovieStorageService) {
    this.searchType = "";
    this.titleType = "";
    this.searchString = "";

    this.subscription = this.searchService.searchSignal.subscribe(data => {
      var arg: string = data;
      var argList: string[] = arg.split("/");
      this.performSearch(argList[0], argList[1], argList[2]);
    }, error => console.log(error))
  }


  ngOnInit(): void {
    console.log(this.isHomeRoute());
    this.searchService.getPopularMovies()
      .subscribe(data => {

        this.popularMoviesList = data;
      }, error => console.log(error))

      this.searchService.getPopularSeries()
      .subscribe(data => {

        this.popularSeriesList = data;
      }, error => console.log(error))
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  performSearch(searchType: string, titleType: string, searchString:string): void {
    if (searchType.toLocaleLowerCase() == "movies"){
      this.searchService.getMovieOrSeriesSearchResult(titleType, searchString)
      .subscribe(data => {
        this.movieList = data;
        this.personList = [];
        this.popularMoviesList = [];
        this.popularSeriesList = [];
      }, error => console.log(error))
    } else {
      this.searchService.getPersonSearchResult(searchString)
      .subscribe(data => {
        this.personList = data;
        this.movieList = [];
        this.popularMoviesList = [];
        this.popularSeriesList = [];
      }, error => console.log(error))
    }
  }

  showMovieDetails(id: string):void {
    this.router.navigate(['movie', id]);
  }

  showPersonDetails(id: string):void {
    this.router.navigate(['person', id])
  }

  addToPlaylist(movie:any):void {
    this.playListStorage.setMovie(movie);
    this.router.navigate(['playlists']);
  }

  isHomeRoute() {
    return this.router.url === '/' ;
  }

  isPlaylistRoute() {
    return this.router.url === '/playlist';
  }

  getRouter() {
    return this.router.url;
  }

  routerUrl = this.router;

}

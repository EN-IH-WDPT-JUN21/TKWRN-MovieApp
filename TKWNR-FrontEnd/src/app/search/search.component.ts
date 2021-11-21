import { SearchService } from './../search.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { SearchResultsComponent } from '../search-results/search-results.component';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  searchType:string;
  titleType:string;
  searchString:string;

  @ViewChild(SearchResultsComponent) searchComponent!: SearchResultsComponent;


  constructor(public searchService: SearchService) {
    this.searchString = "";
    this.searchType = "";
    this.titleType = "";
   }

  ngOnInit(): void {
  }

}

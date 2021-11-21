import { Component, OnInit, ViewChild } from '@angular/core';
import { DataService } from '../data.service';
import { SearchResultsComponent } from '../search-results/search-results.component';

@Component({
  // providers:[SearchResultsComponent],
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  searchType:string;
  titleType:string;
  searchString:string;
  message!:string;

  @ViewChild(SearchResultsComponent) searchComponent!: SearchResultsComponent;


  constructor(private dataService: DataService/* private searchComponent: SearchResultsComponent */) {
    this.searchString = "";
    this.searchType = "";
    this.titleType = "";
   }

  //  performSearch(searchType: string, titleType: string, searchString:string): void {
  //    this.searchComponent.performSearch(searchType, titleType, searchString)
  // }

  ngOnInit(): void {
    this.dataService.sharedMessage.subscribe(message => this.message = message)
  }

}

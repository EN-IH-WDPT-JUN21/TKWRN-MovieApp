import { SearchService } from './../search.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieDetail } from './../models/movie-detail.model';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {

  id: number = 0;
  movie: MovieDetail = new MovieDetail();

  constructor(private route: ActivatedRoute, private router: Router, private searchService:SearchService) { }

  ngOnInit(){
    this.id = this.route.snapshot.params['id'];

    this.searchService.getMovieDetail(this.id)
      .subscribe(data => {
        this.movie = data;
      }, error => console.log(error))
  }



}

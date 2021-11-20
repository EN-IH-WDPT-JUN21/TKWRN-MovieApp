import { MovieDetail } from './../models/movie-detail.model';
import { Component, OnInit, Input } from '@angular/core';
import { Playlist } from 'src/playlist';
import { PlaylistsService } from '../playlists.service';
import { TitleSearchResult } from '../models/title-search-result.model';
import { Observable } from 'rxjs';



@Component({
  selector: 'app-playlist-detail',
  templateUrl: './playlist-detail.component.html',
  styleUrls: ['./playlist-detail.component.css']
})
export class PlaylistDetailComponent implements OnInit {

  @Input()
  playlist!: Playlist;
  playlists!: Observable<Playlist[]>;
  movie!: MovieDetail;
  movies!: TitleSearchResult[];
  movieDTO!: TitleSearchResult;

  constructor(private playlistService: PlaylistsService) {
      this.movie = {
        title:"",
    imageURI:"",
    releaseDate:"",
    runtime:"",
    plot:"",
    creatorDirectorList: [],
    starList: [],
    genres:"",
    companies:"",
    contentRating:"",
    imdbRating:"",
    imdbRatingVotes:0,
    similarList:[],
    }
      this.movies = [];
   }

  ngOnInit(): void {
    
  }

  delete(id: number) {
    this.playlistService.deletePlaylist(id).subscribe(data => {
      location.reload()
  },
    error => console.log(error));
}

addMovie() {
  this.movieDTO = new TitleSearchResult("", this.movie.imageURI, this.movie.title, "");
  this.movies.push(this.movieDTO);
  this.playlistService.addNewMovie(this.playlist.id, this.movie).subscribe(
    data => {
      console.log(this.playlist.movies);
    }
  );
}
}

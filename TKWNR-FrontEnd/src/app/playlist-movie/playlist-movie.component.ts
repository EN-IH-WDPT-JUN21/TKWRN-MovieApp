import { PlaylistsService } from './../playlists.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Playlist } from 'src/playlist';
import { MovieDetail } from './../models/movie-detail.model';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { MovieService } from '../movie.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-playlist-movie',
  templateUrl: './playlist-movie.component.html',
  styleUrls: ['./playlist-movie.component.css']
})
export class PlaylistMovieComponent implements OnInit {
  playlist!: Playlist;
  movies!: MovieDetail[];
  movie!: MovieDetail;
  
    @ViewChild('form')
    form!: NgForm;
    submitted = false;
    constructor(private playlistService: PlaylistsService,
                private movieService: MovieService) {

      this.movies = [];
    }
  
    ngOnInit(): void {
      
    }
  
    showMovies() {
      this.playlistService.getPlaylist(this.playlist.id).subscribe(
        result => {
          this.playlist = result;
          // this.movies = this.playlist.movies!;
        }
      );
    }

    delete(id: number) {
      this.movieService.deleteMovie(id)
        .subscribe(
          data => {
            console.log(data);
          },
          error => console.log(error));
    }
}

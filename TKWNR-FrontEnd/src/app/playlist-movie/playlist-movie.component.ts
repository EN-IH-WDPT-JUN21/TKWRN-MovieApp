import { PlaylistsService } from './../playlists.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Playlist } from 'src/playlist';
import { Movie } from '../movie';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-playlist-movie',
  templateUrl: './playlist-movie.component.html',
  styleUrls: ['./playlist-movie.component.css']
})
export class PlaylistMovieComponent implements OnInit {
  playlist: Playlist;
  //  movies: Movie[] = [];
  movie!: Movie;
  
    @ViewChild('form')
    form!: NgForm;
    submitted = false;
    constructor(private playlistService: PlaylistsService,
                private activatedRoute: ActivatedRoute) {
      this.playlist = {
        id: 0,
        name: '',
        length: 0,
        type: "PUBLIC",
        userName: '',
        movies: []
      }
    }
  
    ngOnInit(): void {
      this.showMovies();
    }
  
    showMovies() {
      const playlistId: number = this.activatedRoute.snapshot.params['playlistId'];
      this.playlistService.getPlaylist(playlistId).subscribe(
        result => {
          this.playlist = result;
        }
      );
    }

    //get playlist by name
    //show name
    //get movies from playlist
    //show movie title, movie poster, link to movie?
  
}

import { Component, OnInit, Input } from '@angular/core';
import { Playlist } from 'src/playlist';
import { PlaylistsService } from '../playlists.service';
import { ActivatedRoute } from '@angular/router';
import { Movie } from '../movie';
import { Observable } from 'rxjs';
import { MovieService } from '../movie.service';


@Component({
  selector: 'app-playlist-detail',
  templateUrl: './playlist-detail.component.html',
  styleUrls: ['./playlist-detail.component.css']
})
export class PlaylistDetailComponent implements OnInit {

  @Input()
  playlist!: Playlist;
  playlists!: Observable<Playlist[]>;
  movie!: Movie;
  movies!: Movie[];

  constructor(private playlistService: PlaylistsService,
             private movieService: MovieService,
              private activatedRoute: ActivatedRoute) {
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
  const movieTitle: string = this.activatedRoute.snapshot.params['movieTitle'];
  this.movieService.getMovieByTitle(movieTitle).subscribe(
    result => {
      this.movie = result;
    }
  );

  this.movies.push(this.movie);
  this.playlistService.addNewMovie(this.playlist.id, this.movie).subscribe(
    data => {
      console.log(this.playlist.movies);
    }
  );
}
}

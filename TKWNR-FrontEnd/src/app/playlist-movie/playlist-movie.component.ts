import { SearchResultsComponent } from './../search-results/search-results.component';
import { PlaylistsService } from './../playlists.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Playlist } from 'src/app/playlist';
import { ActivatedRoute } from '@angular/router';
import { MovieService } from '../movie.service';


@Component({
  selector: 'app-playlist-movie',
  templateUrl: './playlist-movie.component.html',
  styleUrls: ['./playlist-movie.component.css']
})
export class PlaylistMovieComponent implements OnInit {

  id!:number;
  playlist!: Playlist;
  playlistId!:number;

  constructor(private playlistService: PlaylistsService,
             private movieService: MovieService,
             private activatedRoute: ActivatedRoute) {
  }

  @ViewChild(SearchResultsComponent) moviesComponent!: SearchResultsComponent;

  ngOnInit(): void {
    this.playlistId = this.activatedRoute.snapshot.params['id'];
    this.playlist = new Playlist();
    }

  ngAfterViewInit(): void{
      this.playlistService.getMoviesByPlaylistId(this.playlistId)
      .subscribe(data => {
        console.log(data)
        this.moviesComponent.movieList = data;
      }, error => console.log(error))

      this.playlistService.getPlaylist(this.playlistId)
      .subscribe(data => {
        this.playlist = data;
        console.log(data);
        this.playlist.name = this.playlist.name.toUpperCase();
      }, error => console.log(error))
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

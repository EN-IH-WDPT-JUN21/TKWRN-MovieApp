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
  
  constructor(private playlistService: PlaylistsService,
             private movieService: MovieService, 
             private activatedRoute: ActivatedRoute) {
  }

  @ViewChild(SearchResultsComponent) moviesComponent!: SearchResultsComponent;
  
  ngOnInit(): void {
      const playlistId: number = this.activatedRoute.snapshot.params['id'];
      this.playlistService.getMoviesByPlaylistId(playlistId)
      .subscribe(data => {
        this.moviesComponent.movieList = data;
      }, error => console.log(error))
      
      this.playlistService.getPlaylist(playlistId)
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

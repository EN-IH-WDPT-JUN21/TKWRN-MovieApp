import { Component, OnInit, Input } from '@angular/core';
import { Playlist } from 'src/playlist';
import { PlaylistsService } from '../playlists.service';
import { ActivatedRoute } from '@angular/router';
import { Movie } from '../movie';

@Component({
  selector: 'app-playlist-detail',
  templateUrl: './playlist-detail.component.html',
  styleUrls: ['./playlist-detail.component.css']
})
export class PlaylistDetailComponent implements OnInit {

  @Input()
  playlist!: Playlist;
  playlists!: Playlist[];
  movie!: Movie;
  movies!: Movie[];

  constructor(private playlistService: PlaylistsService,
              private activatedRoute: ActivatedRoute) {
      this.movies = [];
      this.playlists = [];
   }

  ngOnInit(): void {
     this.reloadData();
  }

  delete(id: number) {
    this.playlistService.deletePlaylist(id).subscribe(data => {
      // this.playlists.splice(id, 1);
      this.reloadData();
  },
    error => console.log(error));
}

reloadData(): void {
  // this.playlists = this.playlistService.getAllPlaylists();
  this.playlistService.getAllPlaylists().subscribe(
    result => {
      this.playlists = result;
    }
  );
}

addMovie(playlistId: number) {
  //get playlist id 
  // const movieId: string = this.activatedRoute.snapshot.params['movieId'];
  // this.playlistService.getMovieByTitleId(movieId).subscribe(
  //   result => {
  //     this.movie = result;
  //   }
  // );
  this.movie = {
      titleId: "aaaa",
      imageUri: "https://cdn.shopify.com/s/files/1/1148/8924/products/A70-13881-a_1024x1024.jpg?v=1571439846",
      title: "Back to the Future",
      description: "Marty McFly, a 17-year-old high school student, is accidentally sent thirty years into the past in a time-traveling DeLorean invented by his close friend, the eccentric scientist Doc Brown."
      }
  this.movies.push(this.movie);
  this.playlistService.addNewMovie(playlistId, this.movie).subscribe(
    data => {
      console.log(this.playlist.movies);
    }
  );
}
}

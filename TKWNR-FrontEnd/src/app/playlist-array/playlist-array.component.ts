import { Router } from '@angular/router';
import { MovieStorageService } from './../movie-storage.service';
import { PlaylistDetailComponent } from './../playlist-detail/playlist-detail.component';
import { TitleSearchResult } from '../models/title-search-result';
import { Playlist } from 'src/playlist';
import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PlaylistsService } from '../playlists.service';
import { Movie } from '../movie';
import { SearchResultsComponent } from '../search-results/search-results.component';

@Component({
  selector: 'app-playlist-array',
  templateUrl: './playlist-array.component.html',
  styleUrls: ['./playlist-array.component.css']
})
export class PlaylistArrayComponent implements OnInit {
  @ViewChild('form')
  form!: NgForm;
  playlists!: Playlist[];
  playlist: Playlist;
  submitted = false;
  movies!: Movie[];

  @Input()
  movie!: TitleSearchResult;

  constructor(public playlistService: PlaylistsService, public movieStorage:MovieStorageService, private router: Router) { 
      this.playlist = {
        id: 0,
        name: '',
        length: 0,
        userName: localStorage.getItem('username')!,
        type: 'PUBLIC',
      }
    this.playlists = [];
    
    //debugging
    this.playlists.push(new Playlist())
  }

  ngOnInit(): void {
    this.reloadData();
    document.body.classList.add('bg-img');
    this.movie = this.movieStorage.getMovie();
    console.log(this.movie);
  }

  reloadData(): void {
  //  this.playlists = this.playlistService.getAllPlaylists();
  this.playlistService.getAllPlaylists().subscribe(
    result => {
      this.playlists = result;
    }
  );
  }

  save() {
    if(this.playlists.length <= 10) {
      this.playlistService
    .createPlaylist(this.playlist).subscribe(data => {
      this.playlist = new Playlist();
      this.reloadData();
    },
    error => console.log(error));
    } else {
      console.log("Can't add to playlist!")
    }
  }

  onSubmit(): void {
    this.submitted = true;
    this.save();
  }

  addToPlaylist(id:number){
    console.log(this.movie)
      this.playlistService.addNewMovie(id + 1, this.movie).subscribe(
        data => {
          console.log(data);
        }
      );
      this.movie = new TitleSearchResult("", "", "", "null");
      console.log(this.movie);
  }

  showPlaylistDetails(id:number){
    this.router.navigate(['playlists', id])
  }

}

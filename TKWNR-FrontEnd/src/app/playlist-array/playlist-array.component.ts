import { Router } from '@angular/router';
import { MovieStorageService } from './../movie-storage.service';
import { TitleSearchResult } from '../models/title-search-result';
import { Playlist } from 'src/app/playlist';
import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PlaylistsService } from '../playlists.service';
import { Movie } from '../movie';

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
    
    this.playlists.push(new Playlist())
  }

  ngOnInit(): void {
    this.reloadData();
    this.movie = this.movieStorage.getMovie();
  }

  reloadData(): void {
  this.playlistService.getAllPlaylists().subscribe(
    result => {
      this.playlists = result;
    });
  }

  save() {
    if(this.playlists.length <= 9) {
      this.playlistService.createPlaylist(this.playlist).subscribe(data => {
          this.playlist = new Playlist();
          this.reloadData();
      });
    } else {
        console.log("Can't add to playlist!");
        return;
      }
  }

  onSubmit(): void {
    this.submitted = true;
    this.save();
  }

  showPlaylist(id: number) {
    this.playlistService.getPlaylist(id).subscribe(
      data => {
        this.playlist = data;
      }
    )
  }

  addToPlaylist(id:number){
    console.log(this.movie)
      this.playlistService.addNewMovie(id, this.movie).subscribe(
        data => {
          console.log(data);
        }
      );
      this.movie = new TitleSearchResult("", "", "", "null");
      console.log(this.movie);
  }

  deletePlaylist(id: number) {
    this.playlistService.deletePlaylist(id).subscribe(
      data => {
        console.log(data);
        this.reloadData();
      }
    )
  }

  showPlaylistDetails(id:number){
    this.router.navigate(['playlists', id])
  }
}

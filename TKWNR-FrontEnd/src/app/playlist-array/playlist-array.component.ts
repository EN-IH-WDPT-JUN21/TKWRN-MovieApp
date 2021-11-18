import { Playlist } from 'src/playlist';
import { Component, OnInit, ViewChild } from '@angular/core';
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
  movie!: Movie;
  movies!: Movie[];

  constructor(
    private playlistService: PlaylistsService) { 
      this.playlist = {
        id: 0,
        name: '',
        length: 0,
        userName: localStorage.getItem('username')!,
        type: 'PUBLIC',
      }
    this.playlists = [];
  }

  ngOnInit(): void {
    this.reloadData();
    document.body.classList.add('bg-img');
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

}

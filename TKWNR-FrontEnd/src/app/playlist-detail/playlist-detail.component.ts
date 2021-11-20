import { TitleSearchResult } from '../models/title-search-result';
import { Component, OnInit, Input } from '@angular/core';
import { Playlist } from 'src/playlist';
import { PlaylistsService } from '../playlists.service';
import { Observable } from 'rxjs';



@Component({
  selector: 'app-playlist-detail',
  templateUrl: './playlist-detail.component.html',
  styleUrls: ['./playlist-detail.component.css']
})
export class PlaylistDetailComponent implements OnInit {

  @Input()
  movie!:TitleSearchResult;
  playlist!: Playlist;
  playlists!: Playlist[];
  movies!: TitleSearchResult[];
  movieDTO!: TitleSearchResult;

  constructor(private playlistService: PlaylistsService) {
    this.movies = [];
    this.playlists = [];
   }

  ngOnInit(): void {
    this.showPlaylists();
  }


  delete(id: number) {
    this.playlistService.deletePlaylist(id).subscribe(data => {
      location.reload()
  },
    error => console.log(error));
}
showPlaylists() {
  this.playlistService.getAllPlaylists().subscribe(data => {
      this.playlists = data;
  }) 
}

}

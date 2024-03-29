import { TitleSearchResult } from '../models/title-search-result';
import { Component, OnInit, Input } from '@angular/core';
import { PlaylistsService } from '../playlists.service';
import { Observable } from 'rxjs';
import { Playlist } from '../playlist';



@Component({
  selector: 'app-playlist-detail',
  templateUrl: './playlist-detail.component.html',
  styleUrls: ['./playlist-detail.component.css']
})
export class PlaylistDetailComponent implements OnInit {

  @Input()
  movie!:TitleSearchResult;
  playlist!: Playlist;
  playlists!: Observable<Playlist[]>;
  movies!: TitleSearchResult[];
  movieDTO!: TitleSearchResult;

  constructor(private playlistService: PlaylistsService) {
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

}
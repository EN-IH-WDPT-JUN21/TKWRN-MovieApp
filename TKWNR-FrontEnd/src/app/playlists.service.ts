import { HttpClient } from '@angular/common/http';
import { Playlist } from 'src/playlist';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlaylistsService {

  private baseUrl = 'http://localhost:8200/api/playlists';

  constructor(private http: HttpClient) { }

  getPlaylist(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/get/${id}`);
  }

  getAllPlaylists(): Observable<Playlist[]> {
    return this.http.get<Playlist[]>(`${this.baseUrl}`);
  }

  getPlaylistByName(name: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/get?name=name`);
  }

  createPlaylist(playlist: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/new`, playlist);
  }

  updatePlaylist(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/update/${id}`, value);
  }

  addNewMovie(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/update/${id}/add`, value);
  }

  deletePlaylist(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' });
  }

  getMovieByTitleId(id: string): Observable<any> {
    return this.http.get(`/api/search/title/${id}`);
  }

}

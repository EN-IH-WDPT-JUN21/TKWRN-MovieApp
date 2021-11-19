import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = 'http://localhost:8300/api/users';

  constructor(private http: HttpClient) { }

  getUser(username: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${username}`);
  }

  createUser(user: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/new`, user);
  }

  updateUser(username: string, user: Object): Observable<Object> {
    return this.http.put(`${this.baseUrl}/update/${username}`, user);
  }

  deleteUser(username: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${username}`, { responseType: 'text' });
  }

  getUsersList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

}

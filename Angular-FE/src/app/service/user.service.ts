import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import {User} from "../Interface/user.interface";
import {Response} from "../Interface/response.interface";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) {}

  getUsers(): Observable<User[]> {
    return this.http.get<Response>(`http://localhost:8080/users`).pipe(
      map(response => this.processResponse(response))
    );
  }

  getUser( id: number): Observable<any>{
    return this.http.get<any>(`http://localhost:8080/user/${id}`).pipe(
      map(response => this.processResponse(response)));
  }

  private processResponse(response: Response): User[] {
    return response.data.users.map(user => (<User>{
      id: user.id,
      firstName: user.firstName,
      lastName: user.lastName,
      email: user.email
    }));
  }
}

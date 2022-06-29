import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class LoginService {

  constructor(private http: HttpClient) {}
  private pathRouter = API_URL + '/login'

  login(email: string, password: string) {
    const headers = new HttpHeaders({
      autorization: `Basic ${btoa(email+ ':' + password)}` 
    })

    return this.http.get<Object>(this.pathRouter, {headers: headers});
  }
}

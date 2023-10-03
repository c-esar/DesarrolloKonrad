import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from '../entity/usuario';
@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  //Endpoint del Backend
  private backendURL: string = "http://localhost:8081/usuario";

  constructor(
    //HttpClient para proporcionar métodos que reciben datos del backend
    private httpClient: HttpClient
  ) { }

  //Methods
  findAllUsers(): Observable<Usuario[]> {
    return this.httpClient.get<Usuario[]>(`${this.backendURL}/all`);
  }

  findByUsuario(usu: String): Observable<Usuario> {
    return this.httpClient.get<Usuario>(`${this.backendURL}/byUsuario/${usu}`);
  }

  findByIdUsuario(usu: String): Observable<Usuario> {
    return this.httpClient.get<Usuario>(`${this.backendURL}/byId/${usu}`);
  }

  createUser(usuario: Usuario): Observable<Usuario>{
    return this.httpClient.post<Usuario>(`${this.backendURL}/save`, usuario);
  }

  updateUser(usuario: Usuario): Observable<Usuario>{
    return this.httpClient.put<Usuario>(`${this.backendURL}/update`, usuario);
  }

}

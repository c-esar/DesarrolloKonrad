import { Injectable } from '@angular/core';
import { Opcion } from '../entity/opcion';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OpcionService {

  //Endpoint del Backend
private backendURL: string = "http://localhost:8081/opcion";

constructor(
  //HttpClient para proporcionar métodos que reciben datos del backend
  private httpClient: HttpClient
) { }

//Methods
findAllOpcion(): Observable<Opcion[]> {
  return this.httpClient.get<Opcion[]>(`${this.backendURL}/all`);
}


findByIdOpcion(opcion: String): Observable<Opcion> {
  return this.httpClient.get<Opcion>(`${this.backendURL}/byId/${opcion}`);
}

findByIdPregunta(opcion: String): Observable<Opcion[]> {
  return this.httpClient.get<Opcion[]>(`${this.backendURL}/byIdPregunta/${opcion}`);
}

createOpcion(opcion: Opcion): Observable<Opcion>{
  return this.httpClient.post<Opcion>(`${this.backendURL}/save`, opcion);
}

updateOpcion(opcion: Opcion): Observable<Opcion>{
  return this.httpClient.put<Opcion>(`${this.backendURL}/update`, opcion);
}

deleteByPregunta(id: String){
  return this.httpClient.delete(`${this.backendURL}/deleteByPregunta/${id}`);
}

delete(id: String): Observable<Boolean>{
  return this.httpClient.delete<Boolean>(`${this.backendURL}/delete/${id}`);
}

}

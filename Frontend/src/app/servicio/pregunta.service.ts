import { Injectable } from '@angular/core';
import { Pregunta } from '../entity/pregunta';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PreguntaService {
//Endpoint del Backend
private backendURL: string = "http://localhost:8081/pregunta";

constructor(
  //HttpClient para proporcionar métodos que reciben datos del backend
  private httpClient: HttpClient
) { }

//Methods
findAllPregunta(): Observable<Pregunta[]> {
  return this.httpClient.get<Pregunta[]>(`${this.backendURL}/all`);
}


findByIdPregunta(pregunta: String): Observable<Pregunta> {
  return this.httpClient.get<Pregunta>(`${this.backendURL}/byId/${pregunta}`);
}

findByIdFormulario(idFormulario: String): Observable<Pregunta> {
  return this.httpClient.get<Pregunta>(`${this.backendURL}/byFormulario/${idFormulario}`);
}

createPregunta(pregunta: Pregunta): Observable<Pregunta>{
  return this.httpClient.post<Pregunta>(`${this.backendURL}/save`, pregunta);
}

updatePregunta(pregunta: Pregunta): Observable<Pregunta>{
  return this.httpClient.put<Pregunta>(`${this.backendURL}/update`, pregunta);
}
}

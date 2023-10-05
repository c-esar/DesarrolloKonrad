import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Formulario } from '../entity/formulario';

@Injectable({
  providedIn: 'root'
})
export class FormularioService {
 //Endpoint del Backend
 //private backendURL: string = "http://localhost:8081/formulario";
 private backendURL: string  ="https://prueba-konrad-9043b6323108.herokuapp.com/formulario"

 constructor(
   //HttpClient para proporcionar métodos que reciben datos del backend
   private httpClient: HttpClient
 ) { }

 //Methods
 findAllForm(): Observable<Formulario[]> {
   return this.httpClient.get<Formulario[]>(`${this.backendURL}/all`);
 }

 findAllByUser(id: String): Observable<Formulario[]> {
  return this.httpClient.get<Formulario[]>(`${this.backendURL}/byUser/${id}`);
}

 findByIdForm(formulario: String): Observable<Formulario> {
   return this.httpClient.get<Formulario>(`${this.backendURL}/byId/${formulario}`);
 }

 createForm(formulario: Formulario): Observable<Formulario>{
   return this.httpClient.post<Formulario>(`${this.backendURL}/save`, formulario);
 }

 updateForm(formulario: Formulario): Observable<Formulario>{
   return this.httpClient.put<Formulario>(`${this.backendURL}/update`, formulario);
 }

 delete(id: String): Observable<Boolean>{
  return this.httpClient.delete<Boolean>(`${this.backendURL}/delete/${id}`);
}
}

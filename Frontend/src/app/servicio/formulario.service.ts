import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Formulario } from '../entity/formulario';

@Injectable({
  providedIn: 'root'
})
export class FormularioService {
 //Endpoint del Backend
 private backendURL: string = "http://localhost:8081/formulario";

 constructor(
   //HttpClient para proporcionar métodos que reciben datos del backend
   private httpClient: HttpClient
 ) { }

 //Methods
 findAllForm(): Observable<Formulario[]> {
   return this.httpClient.get<Formulario[]>(`${this.backendURL}/all`);
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
}

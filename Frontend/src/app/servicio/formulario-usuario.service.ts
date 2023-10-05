import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormularioUsuario } from '../entity/formulario-usuario';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FormularioUsuarioService {
 //Endpoint del Backend
 //private backendURL: string = "http://localhost:8081/formularioUsuario";

 private backendURL: string  ="https://prueba-konrad-9043b6323108.herokuapp.com/formularioUsuario"

 constructor(
   //HttpClient para proporcionar métodos que reciben datos del backend
   private httpClient: HttpClient
 ) { }

 //Methods
 findAllForm(): Observable<FormularioUsuario[]> {
   return this.httpClient.get<FormularioUsuario[]>(`${this.backendURL}/all`);
 }

 findAllFormAndUsu(form: String, usu: String): Observable<FormularioUsuario[]> {
  return this.httpClient.get<FormularioUsuario[]>(`${this.backendURL}/allFinally/${form}/${usu}`);
}


 findByIdForm(from: String): Observable<FormularioUsuario> {
   return this.httpClient.get<FormularioUsuario>(`${this.backendURL}/byId/${from}`);
 }

 createForm(from: FormularioUsuario[]): Observable<any>{
   return this.httpClient.post<any>(`${this.backendURL}/save`, from);
 }

 updateForm(from: FormularioUsuario): Observable<FormularioUsuario>{
   return this.httpClient.put<FormularioUsuario>(`${this.backendURL}/update`, from);
 }

 delete(id: String): Observable<Boolean>{
  return this.httpClient.delete<Boolean>(`${this.backendURL}/delete/${id}`);
 }

 deleteByFormAndUser(idForm: String, iUser: String): Observable<Boolean>{
  return this.httpClient.delete<Boolean>(`${this.backendURL}/deleteByFormAndUser/${idForm}/${iUser}`);
 }

}

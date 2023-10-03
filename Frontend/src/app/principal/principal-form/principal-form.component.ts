import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/entity/usuario';

@Component({
  selector: 'app-principal-form',
  templateUrl: './principal-form.component.html',
  styleUrls: ['./principal-form.component.css']
})
export class PrincipalFormComponent implements OnInit {

  public usuario  : Usuario = new Usuario();
  
  constructor(private router: Router) { }

  ngOnInit(): void {
   this.datosSesion();
  }

  datosSesion(){
    this.usuario = JSON.parse(localStorage.getItem('Idusuario')|| '{}') ;
    console.log(this.usuario); 
  }

  salir(){
    localStorage.removeItem('Idusuario');
    this.router.navigate(['/login']);
  }

}

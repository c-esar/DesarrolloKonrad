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
  
  constructor(private router: Router) {

   }

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

  title = 'barchartApp';
  public titulo:string[] = ["Preguna1","Pregunta2","Pregunta3"];
  public valor:number[] = [1,4,10];
  public tipo:string ="doughnut";

  public chartClicked(e:any):void{
    console.log(e);
  }

  public chartHavered(e:any):void{
    console.log(e);
  }
}

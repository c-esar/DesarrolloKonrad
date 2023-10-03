import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/entity/usuario';
import { UsuarioService } from 'src/app/servicio/usuario.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  public usuarios : Usuario[] |undefined;
  public usuario  : Usuario = new Usuario();

  constructor(private router: Router, private usuarioService: UsuarioService) { 

  }

  ngOnInit(): void {
    this.getUsers();
    console.log('Usuarios ', this.usuario);
  }

 async login() {
   debugger
   this.usuarioService.findByUsuario(this.usuario.usuario).subscribe(
    //Arrow function, funcion anónima similar a expersiones Lambda
    userData => {
      if(this.usuario.contrasena == userData.contrasena){
        this.usuario = userData
        this.router.navigate(['/inicio']);
      }else{
        alert("Sin acceso");
      }   
    }
  );
 }

 register(){
  this.router.navigate(['/registro']);
 }

 private getUsers(){
  //Utilizamos el servicio inyectado para encontrar los usuarios
  this.usuarioService.findAllUsers().subscribe(
    //Arrow function, funcion anónima similar a expersiones Lambda
    userData => {
      this.usuarios = userData 
    }
  );
}


}

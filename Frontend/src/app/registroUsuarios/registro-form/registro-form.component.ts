import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/entity/usuario';
import { UsuarioService } from 'src/app/servicio/usuario.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-registro-form',
  templateUrl: './registro-form.component.html',
  styleUrls: ['./registro-form.component.css']
})
export class RegistroFormComponent implements OnInit {

  public usuario : Usuario;
  constructor(private router: Router, private usuarioService: UsuarioService) {
    this.usuario = new Usuario();
   }

  ngOnInit(): void {
  }

  save(){
    this.usuario.rol = "USU";
    this.usuarioService.createUser(this.usuario).subscribe(
      //Arrow function, funcion anónima similar a expersiones Lambda
      userData => {
        if(userData.idUsuario != null){
          this.router.navigate(['/login']);
        }else{
          alert(userData.utils?.mensaje);
        }   
      }
    );
  }
}

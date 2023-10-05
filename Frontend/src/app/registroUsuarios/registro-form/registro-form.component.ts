import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/entity/usuario';
import { UsuarioService } from 'src/app/servicio/usuario.service';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-registro-form',
  templateUrl: './registro-form.component.html',
  styleUrls: ['./registro-form.component.css']
})
export class RegistroFormComponent implements OnInit {

  public usuario : Usuario;
  public usuarioSesion : Usuario;
  public usuarios : Usuario[] | any;
  public paramId : string | any = null;
  public admBoolean : Boolean = false ;
  public usuBoolean: Boolean = false;
  constructor(private router: Router, private usuarioService: UsuarioService, private _router : ActivatedRoute) {
    this.usuario = new Usuario();
    this.usuarioSesion = new Usuario();
   }

  ngOnInit(): void {
    this.getParamURL();
    this.datosSesion(); 
    if(this.paramId != null){
      this.getByUsuario();
    }else{ 
      if(this.usuarioSesion != null && this.usuarioSesion.rol == 'ADM'){
        this.getByAllUsuarios();
      }else{
        this.getByUsuarioRegistrado();
      }
    }
    }
    

  datosSesion(){
    this.usuarioSesion = JSON.parse(localStorage.getItem('Idusuario')|| '{}') ;
  }

  getParamURL(){
    this.paramId = this._router.snapshot.paramMap.get('id');
  }

  save(){
    if(this.paramId != null || (this.usuarioSesion.rol == 'USU')){ //update
      if(this.usuarioSesion != null && this.usuarioSesion.rol == 'ADM'){
        if(this.admBoolean){
          this.usuario.rol = "ADM";
        }else{
          this.usuario.rol = "USU";
        }
      }else{
        this.usuario.rol = "USU";
      }
     
      this.usuarioService.updateUser(this.usuario).subscribe(
        //Arrow function, funcion anónima similar a expersiones Lambda
        userData => {
          if(userData.idUsuario != null){
            if(this.usuarioSesion.rol == 'ADM'){
              this.router.navigate(['/inicio']);
            }else{
              this.router.navigate(['/registro']);
            }
            
          }else{
            alert(userData.mensaje);
          }   
        }
      );
    }else{//save
      if(this.usuarioSesion != null && this.usuarioSesion.rol == 'ADM'){
        if(this.admBoolean){
          this.usuario.rol = "ADM";
        }else{
          this.usuario.rol = "USU";
        }
      }else{
        this.usuario.rol = "USU";
      }
     
      this.usuarioService.createUser(this.usuario).subscribe(
        //Arrow function, funcion anónima similar a expersiones Lambda
        userData => {
          debugger
          if(userData.idUsuario != null){
            if(this.usuarioSesion.rol == 'ADM'){
              this.router.navigate(['/inicio']);
            }else{
              this.router.navigate(['/login']);
            }
          }else{
            alert(userData.mensaje);
          }   
        }
      );
    }
    
  }

  getByAllUsuarios(){
    this.usuarioService.findAllUsers().subscribe(
      //Arrow function, funcion anónima similar a expersiones Lambda
      userData => {
        this.usuarios = userData
      }
    );
  }


  getByUsuario(){
    this.usuarioService.findByIdUsuario(this.paramId).subscribe(
      //Arrow function, funcion anónima similar a expersiones Lambda
      userData => {
        this.usuario = userData;
        if(this.usuario.rol == 'ADM'){
          this.admBoolean = true;
        }else{
          this.usuBoolean = true;
        }
      }
    );
  }

  getByUsuarioRegistrado(){
    this.usuarioService.findByIdUsuario(this.usuarioSesion.idUsuario).subscribe(
      //Arrow function, funcion anónima similar a expersiones Lambda
      userData => {
        this.usuario = userData;
          this.usuBoolean = true;
      }
    );
  }
}

import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { finalize } from 'rxjs';
import { Formulario } from 'src/app/entity/formulario';
import { FormularioUsuario } from 'src/app/entity/formulario-usuario';
import { Opcion } from 'src/app/entity/opcion';
import { Pregunta } from 'src/app/entity/pregunta';
import { Usuario } from 'src/app/entity/usuario';
import { FormularioUsuarioService } from 'src/app/servicio/formulario-usuario.service';
import { FormularioService } from 'src/app/servicio/formulario.service';
import { OpcionService } from 'src/app/servicio/opcion.service';
import { PreguntaService } from 'src/app/servicio/pregunta.service';

@Component({
  selector: 'app-formulario-usuario-form',
  templateUrl: './formulario-usuario-form.component.html',
  styleUrls: ['./formulario-usuario-form.component.css']
})
export class FormularioUsuarioFormComponent implements OnInit {

  public formularios: Formulario[] | any;
  public paramId: string | any = null;

  public seFormulario: Formulario | any;
  public sePregunta: Pregunta[] = new Array();
  public seOpcion: Opcion[] = new Array();
  public usuario  : Usuario = new Usuario();
  public guardarPregunta: FormularioUsuario[] = new Array();
  constructor(private router: Router, private formularioService: FormularioService, private _router: ActivatedRoute, private preguntaService: PreguntaService,
    private opcionService: OpcionService, private formularioguardar: FormularioUsuarioService) { }

  ngOnInit(): void {
    this.usuario = JSON.parse(localStorage.getItem('Idusuario')|| '{}') ;
    this.getParamURL();
    if (this.paramId != null) {
      this.seForm();
    }else{
      this.getByAllForm();
    }
  }

  getByAllForm() {
    this.formularioService.findAllByUser(this.usuario.idUsuario).subscribe(
      userData => {
        this.formularios = userData
      }
    );
  }

  getParamURL() {
    this.paramId = this._router.snapshot.paramMap.get('idForm');
  }

  seForm() {
    this.preguntaService.findByIdFormulario(this.paramId).pipe(finalize(() => this.seOpcions())).subscribe(
      userData => {
        if (userData != null) {
          this.sePregunta = userData;
        }
      }
    );
  }

  seOpcions() {
    for (var i = 0; i < this.sePregunta.length; i++) {
      this.opcionService.findByIdPregunta(this.sePregunta[i].idPregunta).subscribe(
        userData => {
          debugger
          if (userData != null) {
            for (var j = 0; j < userData.length; j++) {
            this.seOpcion.push(userData[j]);
            }
          }
        }
      );
    }
  }

  getOpcionsPregunta(id: number): Opcion[]{
    var temp : Opcion[] =[];
    for (var i = 0; i < this.seOpcion.length; i++) {
      if(this.seOpcion[i].pregunta.idPregunta == id){
        temp.push(this.seOpcion[i]);
      }
    }
    return temp;
  }

  onChange(pre: Pregunta, opc :Opcion, idPregunta : Number, idOpcion: Number){
    debugger
    var temp :  FormularioUsuario = new FormularioUsuario();
    temp.formulario = Math.floor(this.paramId);
    temp.opcionPregunta = opc.idOpcion;
    temp.pregunta = pre.idPregunta;
    temp.usuario = this.usuario.idUsuario;
    this.guardarPregunta.push(temp);
  }

  saveForm(){
  debugger
    this.formularioguardar.createForm(this.guardarPregunta).subscribe(
      userData => {
        if(userData != null){
          alert("Formulario guardado");
          this.router.navigate(['/formulariosRealizar']);
        }
      }
    );
  }

}

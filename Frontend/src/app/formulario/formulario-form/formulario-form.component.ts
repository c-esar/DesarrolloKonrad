import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { finalize } from 'rxjs';
import { Formulario } from 'src/app/entity/formulario';
import { Opcion } from 'src/app/entity/opcion';
import { Pregunta } from 'src/app/entity/pregunta';
import { FormularioService } from 'src/app/servicio/formulario.service';
import { OpcionService } from 'src/app/servicio/opcion.service';
import { PreguntaService } from 'src/app/servicio/pregunta.service';

@Component({
  selector: 'app-formulario-form',
  templateUrl: './formulario-form.component.html',
  styleUrls: ['./formulario-form.component.css']
})
export class FormularioFormComponent implements OnInit {

  public formularios: Formulario[] | any;
  public formulario: Formulario | any;
  public editarBoolean: Boolean | any;
  public crearBoolean: Boolean | any;
  public paramId: string | any = null;
  public accion: string | any = null;
  public preguntas: Pregunta[] | any;
  public seBoolean: Boolean | any = false;

  public seFormulario: Formulario | any;
  public sePregunta: Pregunta[] = new Array();
  public seOpcion: Opcion[] = new Array();

  constructor(private router: Router, private formularioService: FormularioService, private _router: ActivatedRoute, private preguntaService: PreguntaService,
    private opcionService: OpcionService) {
    this.formulario = new Formulario();
  }

  ngOnInit(): void {
    this.getParamURL();
    if (this.accion == "VER") {
      this.seBoolean = true;
      this.seForm();
    } else {
      if (this.paramId != null) {
        this.editarBoolean = true;
        this.getById();
      } else {
        this.editarBoolean = false;
        this.getByAllForm();
      }
    }


  }

  getByAllForm() {
    this.formularioService.findAllForm().subscribe(
      userData => {
        this.formularios = userData
      }
    );
  }

  getById() {
    this.formularioService.findByIdForm(this.paramId).subscribe(
      userData => {
        this.formulario = userData
      }
    );
    this.preguntaService.findByIdFormulario(this.paramId).subscribe(
      userData => {
        this.preguntas = userData;
      }
    );
  }

  getParamURL() {
    this.paramId = this._router.snapshot.paramMap.get('id');
    this.accion = this._router.snapshot.paramMap.get('act');
  }

  createForm() {
    this.formularioService.createForm(this.formulario).subscribe(
      //Arrow function, funcion anónima similar a expersiones Lambda
      userData => {
        if (userData.idFormulario != null) {
          this.crearBoolean = false;
          this.editarBoolean = false;
          this.getByAllForm();
          this.formulario = new Formulario();
          this.router.navigate(['/inicio']);
        } else {
          alert(userData.mensaje);
        }
      }
    );
  }

  eliminarOpcion(id: number | any) {
    this.preguntaService.delete(this.preguntas[id].idPregunta).subscribe(
      userData => {
        if (userData) {
          this.preguntas.splice(id, 1);
        }
      }
    );

  }

  crearFormNuevo() {
    this.crearBoolean = true;
    this.editarBoolean = true;
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
    debugger
    var temp : Opcion[] =[];
    for (var i = 0; i < this.seOpcion.length; i++) {
      if(this.seOpcion[i].pregunta.idPregunta == id){
        temp.push(this.seOpcion[i]);
      }
    }
    return temp;
  }

  deleteForm(id:number){
    this.formularioService.delete(this.formularios[id].idFormulario).subscribe(
      //Arrow function, funcion anónima similar a expersiones Lambda
      userData => {
        if (userData) {
          this.formularios.splice(id, 1);
        }
      }
    );
  }

}


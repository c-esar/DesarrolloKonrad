import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { finalize } from 'rxjs';
import { Opcion } from 'src/app/entity/opcion';
import { Pregunta } from 'src/app/entity/pregunta';
import { OpcionService } from 'src/app/servicio/opcion.service';
import { PreguntaService } from 'src/app/servicio/pregunta.service';

@Component({
  selector: 'app-pregunta-form',
  templateUrl: './pregunta-form.component.html',
  styleUrls: ['./pregunta-form.component.css']
})
export class PreguntaFormComponent implements OnInit {

  public pregunta : Pregunta | any;
  public opcionBoolean : Boolean | any;
  public opcionEditarBoolean : Boolean | any;
  opcions : Opcion[] = [];
  public opcion : Opcion | any;
  public opcionEditar : Opcion | any;
  public valSeled : number | any;
  public paramIdFormulario: string | any = null;
  constructor(private router: Router, private preguntaService: PreguntaService, private _router : ActivatedRoute,
    private opcionService: OpcionService) { 
    this.pregunta = new Pregunta();
    this.opcion = new Opcion();
    this.opcionEditar = new Opcion();
    this.opcions = [];
    
  }

  ngOnInit(): void {
    this.getParamURL();
  }


  async createPregun(){
    debugger
    for (var i = 0; i < this.opcions.length; i++) {
      this.opcions[i].idPregunta.idPregunta = this.pregunta.idPregunta;
      this.opcions[i].idPregunta.formulario.idFormulario = this.paramIdFormulario;
      this.opcionService.createOpcion(this.opcions[i]).subscribe(
        //Arrow function, funcion anónima similar a expersiones Lambda
        userData => {
          debugger
          if (userData.idOpcion != null) {
           
          } else {
             //alert(userData.utils?.mensaje);
          }
        }
      );
     }
     this.router.navigate(['/formulario']);
  }

  async cratePreguns(){
    this.pregunta.formulario.idFormulario = this.paramIdFormulario;
    this.preguntaService.createPregunta(this.pregunta).pipe(finalize( () => this.createPregun()))
    .subscribe(
      userData => {
        debugger
        if (userData.idPregunta != null) {
         this.pregunta = userData
        } else {
          // alert(userData.utils?.mensaje);
        }
      });
  }

  createOpcion(){
    this.opcionBoolean = true;
    this.opcionEditarBoolean = false;
  }

  editarOpcion(id: number | any){
    this.valSeled = id;
    this.opcionEditarBoolean = true;
    this.opcionBoolean = false;
   // this.opcionEditar = this.opcions[id];

  }

  eliminarOpcion(id: number | any){
    this.opcions.splice(this.valSeled, 1);

  }

  editarOpcionForm(){
    debugger
    this.opcions.splice(this.valSeled, 1);
    this.opcions.push(this.opcionEditar);
    this.opcionEditar = new Opcion();
    this.opcionBoolean = false;
    this.opcionEditarBoolean = false;
  }

  createOpcionBack(){
    this.opcions.push(this.opcion);
    this.opcion = new Opcion();
    this.opcionBoolean = false;
    this.opcionEditarBoolean = false;
  }

  getParamURL() {
    this.paramIdFormulario = this._router.snapshot.paramMap.get('id');
  }

}
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Formulario } from 'src/app/entity/formulario';
import { Pregunta } from 'src/app/entity/pregunta';
import { FormularioService } from 'src/app/servicio/formulario.service';
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
  public preguntas: Pregunta[] | any;
  constructor(private router: Router, private formularioService: FormularioService, private _router: ActivatedRoute, private preguntaService: PreguntaService) {
    this.formulario = new Formulario();
  }

  ngOnInit(): void {
    this.getParamURL();
    if (this.paramId != null) {
      this.editarBoolean = true;
      this.getById();
    } else {
      this.editarBoolean = false;
      this.getByAllForm();
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
        this.preguntas = userData
      }
    );
  }

  getParamURL() {
    this.paramId = this._router.snapshot.paramMap.get('id');
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
        } else {
           alert(userData.utils?.mensaje);
        }
      }
    );
  }

  crearFormNuevo() {
    this.crearBoolean = true;
    this.editarBoolean = true;
  }
}


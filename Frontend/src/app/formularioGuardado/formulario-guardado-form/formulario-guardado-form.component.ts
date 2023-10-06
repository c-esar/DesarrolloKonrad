import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { finalize } from 'rxjs';
import { FormularioUsuario } from 'src/app/entity/formulario-usuario';
import { FormularioUsuarioService } from 'src/app/servicio/formulario-usuario.service';
import { FormularioService } from 'src/app/servicio/formulario.service';
import { OpcionService } from 'src/app/servicio/opcion.service';
import { PreguntaService } from 'src/app/servicio/pregunta.service';
import { UsuarioService } from 'src/app/servicio/usuario.service';

@Component({
  selector: 'app-formulario-guardado-form',
  templateUrl: './formulario-guardado-form.component.html',
  styleUrls: ['./formulario-guardado-form.component.css','./formulario-guardado-form2.component.css']
})
export class FormularioGuardadoFormComponent implements OnInit {

  public formularios : FormularioUsuario[] = new Array();
  public formulariosMostrar : FormularioUsuario[] = new Array();
  public paramId: string | any = null;
  public paramUsu: string | any = null;
  constructor(private router: Router, private formularioService: FormularioUsuarioService, private _router: ActivatedRoute, private preguntaService: PreguntaService,
    private opcionService: OpcionService, private usuarioService : UsuarioService) {
      this.formulariosMostrar = new Array();
  }

  ngOnInit(): void {
    debugger
    this.getParamURL();
    if(this.paramId != null && this.paramUsu != null){
      this.getByAllFormAndUsu();
    }else{
      this.getByAllForm();
    }

  }

  getByAllFormAndUsu() {
    debugger
    this.formularioService.findAllFormAndUsu(this.paramId,this.paramUsu).subscribe(
      userData => {
        debugger
        this.formulariosMostrar = userData
      }
    );
  }

  getByAllForm() {
    this.formularioService.findAllForm().subscribe(
      userData => {
        this.formularios = userData
      }
    );
  }

  getParamURL() {
    this.paramId = this._router.snapshot.paramMap.get('idForm');
    this.paramUsu = this._router.snapshot.paramMap.get('idUsu');
  }

  deleteFormResp(idForm: String, idUser: String, pos: number){
    this.formularioService.deleteByFormAndUser(idForm,idUser).subscribe(
      userData => {
        if (userData) {
          this.formularios.splice(pos, 1);
        }
      }
    );
  }
}

import { Formulario } from "./formulario";
import { Opcion } from "./opcion";
import { Pregunta } from "./pregunta";
import { Usuario } from "./usuario";
import { Utils } from "./utils";

export class FormularioUsuario {
idFormularioUsuario : number | any;
idFormulario : Formulario | any;
idUsuario: Usuario | any;
idPregunta : Pregunta | any;
idOpcionPregunta: Opcion | any;
formulario : number | any;
usuario: number | any;
pregunta : number | any;
opcionPregunta: number | any;
utils: Utils | any;


constructor(_usu: Usuario){
    this.idFormulario = new Formulario();
    this.idUsuario = _usu;
}

}

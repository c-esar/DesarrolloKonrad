import { Formulario } from "./formulario";
import { Opcion } from "./opcion";
import { Pregunta } from "./pregunta";
import { Usuario } from "./usuario";

export class FormularioUsuario {
idFormularioUsuario : number | undefined;
idFormulario : Formulario | undefined;
idUsuario: Usuario | undefined;
idPregunta : Pregunta | undefined;
idOpcionPregunta: Opcion | undefined;

}

import { Formulario } from "./formulario";
import { Opcion } from "./opcion";

export class Pregunta {
    idPregunta: number | any;
    nombrePregunta: string | any;
    formulario: Formulario | any;

    constructor(){
        this.idPregunta = null;
        this.formulario = new Formulario();
    }
}

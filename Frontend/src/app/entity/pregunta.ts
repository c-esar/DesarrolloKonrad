import { Formulario } from "./formulario";
import { Opcion } from "./opcion";
import { Utils } from "./utils";

export class Pregunta {
    idPregunta: number | any;
    nombrePregunta: string | any;
    formulario: Formulario | any;
    utils: Utils | any;
    opcion: Opcion[] ;
    constructor(){
        this.idPregunta = null;
        this.formulario = new Formulario();
        this.nombrePregunta = "";
        this.opcion = [];
    }
}

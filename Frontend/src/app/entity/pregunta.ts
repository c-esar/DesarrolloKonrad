import { Formulario } from "./formulario";
import { Opcion } from "./opcion";
import { Utils } from "./utils";

export class Pregunta extends Utils{
    idPregunta: number | any;
    nombrePregunta: string | any;
    formulario: Formulario | any;
    opcion: Opcion[] ;
    constructor(){
        super();
        this.idPregunta = null;
        this.formulario = new Formulario();
        this.nombrePregunta = "";
        this.opcion = [];
    }
}

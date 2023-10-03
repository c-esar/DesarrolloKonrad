import { Pregunta } from "./pregunta";

export class Opcion {
    idOpcion: number | any;
    nombreOpcion: number | any;
    idPregunta: Pregunta | any;

    constructor(){
        this.idPregunta = new Pregunta();
    }
}

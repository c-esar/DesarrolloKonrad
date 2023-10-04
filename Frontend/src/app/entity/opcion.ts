import { Pregunta } from "./pregunta";
import { Utils } from "./utils";

export class Opcion {
    idOpcion: number | any;
    nombreOpcion: number | any;
    pregunta: Pregunta | any;
    utils: Utils | any;
    constructor(){
        this.idOpcion =  null;
        this.nombreOpcion = "";
        this.pregunta = new Pregunta();
    }
}

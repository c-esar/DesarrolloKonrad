import { Pregunta } from "./pregunta";
import { Utils } from "./utils";

export class Opcion extends Utils{
    idOpcion: number | any;
    nombreOpcion: number | any;
    pregunta: Pregunta | any;
    constructor(){
        super();
        this.idOpcion =  null;
        this.nombreOpcion = "";
        this.pregunta = new Pregunta();
    }
}

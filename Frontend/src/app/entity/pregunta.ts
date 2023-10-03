import { Formulario } from "./formulario";
import { Opcion } from "./opcion";

export class Pregunta {
    idPregunta: number | undefined;
    nombreOpcion: string | undefined;
    idFormulario: Formulario | undefined;
    opcion : Opcion[] | undefined;

    constructor(){}
}

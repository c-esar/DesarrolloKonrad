import { Utils } from "./utils";

export class Usuario extends Utils{
idUsuario: number | any ;
nombreUsuario: string | any;
usuario: string;
contrasena: string;
rol: string| any;
correo: string| any;
constructor(){
    super();
    this.usuario = "";
    this.contrasena ="";
}

}

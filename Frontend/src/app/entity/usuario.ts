import { Utils } from "./utils";

export class Usuario {
idUsuario: number| undefined;
nombreUsuario: string | undefined;
usuario: string;
contrasena: string;
rol: string| undefined;
correo: string| undefined;
utils: Utils | undefined;
constructor(){
    this.usuario = "";
    this.contrasena ="";
}

}

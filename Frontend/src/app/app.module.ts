import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginFormComponent } from './login/login-form/login-form.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RegistroFormComponent } from './registroUsuarios/registro-form/registro-form.component';
import { PrincipalFormComponent } from './principal/principal-form/principal-form.component';
import { FormularioFormComponent } from './formulario/formulario-form/formulario-form.component';
import { PreguntaFormComponent } from './pregunta/pregunta-form/pregunta-form.component';
import { FormularioUsuarioFormComponent } from './formularioUsuario/formulario-usuario-form/formulario-usuario-form.component';
import { FormularioGuardadoFormComponent } from './formularioGuardado/formulario-guardado-form/formulario-guardado-form.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
    RegistroFormComponent,
    PrincipalFormComponent,
    FormularioFormComponent,
    PreguntaFormComponent,
    FormularioUsuarioFormComponent,
    FormularioGuardadoFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

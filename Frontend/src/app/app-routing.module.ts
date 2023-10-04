import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginFormComponent } from './login/login-form/login-form.component';
import { PrincipalFormComponent } from './principal/principal-form/principal-form.component';
import { RegistroFormComponent } from './registroUsuarios/registro-form/registro-form.component';
import { FormularioFormComponent } from './formulario/formulario-form/formulario-form.component';
import { PreguntaFormComponent } from './pregunta/pregunta-form/pregunta-form.component';
import { FormularioUsuarioFormComponent } from './formularioUsuario/formulario-usuario-form/formulario-usuario-form.component';
import { FormularioGuardadoFormComponent } from './formularioGuardado/formulario-guardado-form/formulario-guardado-form.component';

const   routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginFormComponent },
  { path: 'registro', component: RegistroFormComponent },
  { path: 'registro/:id', component: RegistroFormComponent },
  { path: 'inicio', component: PrincipalFormComponent },
  { path: 'formulario', component: FormularioFormComponent },
  { path: 'formulario/:id/:act', component: FormularioFormComponent },
  { path: 'pregunta', component: PreguntaFormComponent },
  { path: 'pregunta/:idForm', component: PreguntaFormComponent },
  { path: 'pregunta/:id/:idForm', component: PreguntaFormComponent },
  { path: 'formulariosRealizar', component: FormularioUsuarioFormComponent },
  { path: 'formulariosRealizar/:idForm', component: FormularioUsuarioFormComponent },
  { path: 'formulariosGuardado', component: FormularioGuardadoFormComponent },
  { path: 'formulariosGuardado/:idForm/:idUsu', component: FormularioGuardadoFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

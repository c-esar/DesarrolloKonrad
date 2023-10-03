import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginFormComponent } from './login/login-form/login-form.component';
import { PrincipalFormComponent } from './principal/principal-form/principal-form.component';
import { RegistroFormComponent } from './registroUsuarios/registro-form/registro-form.component';

const   routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginFormComponent },
  { path: 'registro', component: RegistroFormComponent },
  { path: 'inicio', component: PrincipalFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { ComponentRef, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EspecialidadeFormComponent } from './especialidade-form/especialidade-form.component';
import { EspecialidadeListaComponent } from './especialidade-lista/especialidade-lista.component';


const routes: Routes = [
  {path: 'especialidade-form', component: EspecialidadeFormComponent},
  {path: 'especialidade-listagem', component: EspecialidadeListaComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EspecialidadeRoutingModule { }

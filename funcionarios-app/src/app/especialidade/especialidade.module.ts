import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'

import { EspecialidadeRoutingModule } from './especialidade-routing.module';
import { EspecialidadeFormComponent } from './especialidade-form/especialidade-form.component';
import { EspecialidadeListaComponent } from './especialidade-lista/especialidade-lista.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [EspecialidadeFormComponent, EspecialidadeListaComponent],
  imports: [
    CommonModule,
    EspecialidadeRoutingModule,
    FormsModule,
    RouterModule
  ], exports :[
    EspecialidadeFormComponent,
    EspecialidadeListaComponent
  ]
})
export class EspecialidadeModule { }

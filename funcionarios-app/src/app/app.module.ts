import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@Angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { TemplateModule } from './template/template.module';
import { HomeComponent } from './home/home.component';
import { FuncionariosModule } from './funcionarios/funcionarios.module';
import { FuncionariosService } from './funcionarios.service'
import { EspecialidadeModule } from './especialidade/especialidade.module'

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    TemplateModule,
    FuncionariosModule,
    EspecialidadeModule
  ],
  providers: [
    FuncionariosService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

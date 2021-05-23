import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EspecialidadeService } from 'src/app/especialidade.service';
import { Especialidade } from '../Especialidade';

@Component({
  selector: 'app-especialidade-lista',
  templateUrl: './especialidade-lista.component.html',
  styleUrls: ['./especialidade-lista.component.css']
})
export class EspecialidadeListaComponent implements OnInit {

  especialidades: Especialidade[] = [];
  especialidadeSelecionada: Especialidade;
  mensagemSucesso: string;
  mensagemErro: string;

  constructor(private service: EspecialidadeService, 
    private router: Router) { }

  ngOnInit(): void {
    this.service.getEspecialidades()
    .subscribe( resposta => this.especialidades = resposta)
  }

  novoCadastro(){
    this.router.navigate(['/especialidade-form'])
  }

  preparaDelecao(especialidade: Especialidade){
    this.especialidadeSelecionada = especialidade;
  }


  deletarFuncionario(){
    this.service
    .deletar(this.especialidadeSelecionada)
    .subscribe(
      response =>{this.mensagemSucesso = 'Especialidade deletada com sucesso!'
      this.ngOnInit();
    },
      erro => this.mensagemErro ='Ocorreu erro ao deletar o especialidade'
    )
  }


}

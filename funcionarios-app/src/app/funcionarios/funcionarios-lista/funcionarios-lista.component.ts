import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FuncionariosService } from '../../funcionarios.service';
import { Funcionario } from '../funcionario';

@Component({
  selector: 'app-funcionarios-lista',
  templateUrl: './funcionarios-lista.component.html',
  styleUrls: ['./funcionarios-lista.component.css']
})
export class FuncionariosListaComponent implements OnInit {

  funcionarios: Funcionario[] = [];
  funcionarioSelecionado: Funcionario;
  mensagemSucesso: string;
  mensagemErro: string;

  constructor(private service: FuncionariosService, 
    private router: Router) { }

  ngOnInit(): void {
    this.service.getFuncionarios()
    .subscribe( resposta => this.funcionarios = resposta)
  }

  novoCadastro(){
    this.router.navigate(['/funcionarios-form'])
  }


  preparaDelecao(funcionario: Funcionario){
    this.funcionarioSelecionado = funcionario;
  }


  deletarFuncionario(){
    this.service
    .deletar(this.funcionarioSelecionado)
    .subscribe(
      response =>{this.mensagemSucesso = 'Funcionario deletado com sucesso!'
      this.ngOnInit();
    },
      erro => this.mensagemErro ='Ocorreu erro ao deletar o funcionario'
    )
  }
}

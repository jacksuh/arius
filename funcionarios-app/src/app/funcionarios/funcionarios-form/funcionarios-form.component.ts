import { Component, OnInit } from '@angular/core';
import { Funcionario } from '../funcionario';
import { FuncionariosService } from '../../funcionarios.service'
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Observable } from 'rxjs';
import { Especialidade } from '../../especialidade/Especialidade'
import { EspecialidadeService } from '../../especialidade.service'

@Component({
  selector: 'app-funcionarios-form',
  templateUrl: './funcionarios-form.component.html',
  styleUrls: ['./funcionarios-form.component.css']
})
export class FuncionariosFormComponent implements OnInit {

  funcionario: Funcionario;
  sucess: boolean = false;
  errors: String[];
  id: number; 

  especialidades: Especialidade[] = []

  constructor(private service: FuncionariosService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private especialidadeService: EspecialidadeService) { 
    this.funcionario = new Funcionario();
  }

  voltarPListagem(){
    this.router.navigate(['/funcionarios-lista']);
  }

  ngOnInit(): void {
    this.especialidadeService.getEspecialidades()
    .subscribe( response => this.especialidades = response);

   let params : Observable<Params> =  this.activatedRoute.params
   params.subscribe(urlParams =>{
     this.id = urlParams['id'];
     this.service.getFuncionarioById(this.id)
    .subscribe( response => this.funcionario = response,
    errorResponse => this.funcionario = new Funcionario()
    )
   })
  }

  onSubmit(){
    if(this.id){
      this.service.atualizar(this.funcionario)
      .subscribe(response => {
        this.sucess = true;
        this.errors = null;
      }, errorResponse => {
        this.errors = ['Erro ao atualizar o Cliente']
      })

    }else{}
    this.service.salvar(this.funcionario)
    .subscribe(response =>{
      this.sucess = true;
      this.funcionario = response;
    })
  }
}


import { Component, OnInit } from '@angular/core';
import { Especialidade } from '../Especialidade';
import { EspecialidadeService } from '../../especialidade.service';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-especialidade-form',
  templateUrl: './especialidade-form.component.html',
  styleUrls: ['./especialidade-form.component.css']
})
export class EspecialidadeFormComponent implements OnInit {

  especialidade: Especialidade;
  mensagemSucesso: string;
  mensagemErro: string;
  sucess: boolean = false;
  errors: String[];
  id: number; 

  constructor(private service: EspecialidadeService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private especialidadeService: EspecialidadeService) { 
    this.especialidade = new Especialidade();
   }

   ngOnInit(): void {
  
   let params : Observable<Params> =  this.activatedRoute.params
   params.subscribe(urlParams =>{
     this.id = urlParams['id'];
     this.service.getFuncionarioById(this.id)
    .subscribe( response => this.especialidade = response,
    errorResponse => this.especialidade = new Especialidade()
    )
   })
  }


  onSubmit(){
    if(this.id){
      this.service.atualizar(this.especialidade)
      .subscribe(response => {
        this.sucess = true;
        this.errors = null;
      }, errorResponse => {
        this.errors = ['Erro ao atualizar a Especialidade']
      })

    }else{
    this.service.salvar(this.especialidade)
    .subscribe(response =>{
      this.sucess = true;
      this.especialidade = response;
    })
  }
  }

  voltarPListagem(){
    this.router.navigate(['/especialidade-lista'])
  }
}

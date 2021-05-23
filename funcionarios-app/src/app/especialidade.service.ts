import { Injectable } from '@angular/core';
import {HttpClient} from '@Angular/common/http';
import { Especialidade } from './especialidade/Especialidade';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EspecialidadeService {

  constructor(private http: HttpClient) { 


  }


  salvar(especialidade: Especialidade) : Observable<any>{
    return this.http.post<Especialidade>('http://localhost:8080/api/especialidade',especialidade);
   }

  getEspecialidades(): Observable<any[]>{
    return this.http.get<Especialidade[]>('http://localhost:8080/api/especialidade');
  }

   atualizar(especialidade: Especialidade) : Observable<Especialidade>{
    return this.http.put<Especialidade>(`http://localhost:8080/api/especialidade/${especialidade.id}`, especialidade);
   }

   getFuncionarioById(id: number) : Observable<Especialidade>{
    return this.http.get<Especialidade>(`http://localhost:8080/api/especialidade/${id}`);

   }

   deletar(especialidade: Especialidade): Observable<any>{
     return this.http.delete<any>(`http://localhost:8080/api/especialidade/${especialidade.id}`);
   }


}

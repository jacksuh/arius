import { Injectable } from '@angular/core';
import {HttpClient} from '@Angular/common/http';
import { Especialidade } from './especialidade/Especialidade';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EspecialidadeService {

  constructor(private http: HttpClient) { }


  getEspecialidades(): Observable<any[]>{
    return this.http.get<Especialidade[]>('http://localhost:8080/api/especialidade');
  }
}

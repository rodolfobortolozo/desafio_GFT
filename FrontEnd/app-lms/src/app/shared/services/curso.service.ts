import { Injectable } from '@angular/core';
import { Curso } from '../model/curso,model';
import { BaseService } from '../../arquitetura/service/base-service';

@Injectable({
  providedIn: 'root'
})
export class CursoService extends BaseService<Curso> {

  constructor() {
    super('/curso')
  }

  buscarCursosComMatricula(id : number) {
    return this.http.get<Curso[]>(`${this.baseUrl}/matriculado/${id}`, this.options); 
  }
  
}

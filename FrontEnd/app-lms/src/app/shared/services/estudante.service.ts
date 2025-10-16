import { Injectable } from '@angular/core';
import { BaseService } from '../../arquitetura/service/base-service';
import { Estudante } from '../model/estudante.model';

@Injectable({
  providedIn: 'root'
})
export class EstudanteService extends BaseService<Estudante> {

  constructor() {
    super('/estudante')
  }
  
}

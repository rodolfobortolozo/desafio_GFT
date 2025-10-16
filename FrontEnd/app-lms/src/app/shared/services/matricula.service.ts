import { Injectable } from '@angular/core';
import { BaseService } from '../../arquitetura/service/base-service';
import { Matricula } from '../model/matricula.model';

@Injectable({
  providedIn: 'root'
})
export class MatriculaService extends BaseService<Matricula> {

  constructor() {
    super('/matricula')
  }
}
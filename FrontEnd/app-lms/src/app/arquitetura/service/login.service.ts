import { Injectable } from '@angular/core';
import { BaseService } from './base-service';
import { Login } from '../model/login.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService extends BaseService<Login> {
  

  constructor() {
    super('/login')
   }

  login(entity: Login): Observable<Login> {
    return this.http.post<Login>(this.baseUrl, entity, this.options)
  }


  
}

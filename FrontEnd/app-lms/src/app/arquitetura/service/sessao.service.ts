import { inject, Injectable } from '@angular/core';
import { Login } from '../model/login.model';
import { LoginService } from './login.service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class SessaoService {
  
  private readonly router = inject(Router)
  private readonly ID_TOKEN = 'lmsToken';

  readonly usuario : Login = {} as Login; 

  isLoggedIn() : boolean {
    if (typeof window === 'undefined') return false; 
    const localStorageToken = localStorage.getItem(this.ID_TOKEN);
    if (!localStorageToken) {
      return false;
    }
    return true
  }

  getToken(): Login | null  {
    if (typeof window === 'undefined') return null; 
    return this.isLoggedIn() ? JSON.parse(localStorage.getItem(this.ID_TOKEN) || '{}') : null;
  }

  dataUsers() : Login{
    const usuario : Login = {} as Login; 
    usuario.nivel = this.getToken()?.nivel;
    usuario.nome = this.getToken()?.nome;
    usuario.nivel = this.getToken()?.nivel;
    usuario.token = this.getToken()?.token;
    usuario.id = this.getToken()?.id;
    return usuario
  }

  logout(){
    if (typeof window === 'undefined') return; 
    localStorage.removeItem(this.ID_TOKEN);
    this.router.navigate(['/']);
  }

}

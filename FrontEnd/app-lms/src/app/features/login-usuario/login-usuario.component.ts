import { Component, Inject, inject } from '@angular/core';
import { LoginService } from '../../arquitetura/service/login.service';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { Login } from '../../arquitetura/model/login.model';
import { Router, RouterLink } from '@angular/router';
import { SessaoService } from '../../arquitetura/service/sessao.service';

@Component({
  selector: 'app-login-usuario',
  imports: [CommonModule, MatCardModule, MatButtonModule, ReactiveFormsModule, MatFormFieldModule, MatInputModule],

templateUrl: './login-usuario.component.html',
  styleUrl: './login-usuario.component.scss'
})
export class LoginUsuarioComponent {

  private readonly fb = inject(FormBuilder);
  private readonly loginService = inject(LoginService);
  private readonly router = inject(Router);
  private readonly sessaoService = inject(SessaoService);

  private readonly ID_TOKEN = 'lmsToken';

  form = this.fb.group({
    usuario: ['', Validators.required],
    senha: ['', Validators.required]
  });

  login(){
    
    this.loginService.login(this.form.value as Login).subscribe({
      next: (res) =>{
        localStorage.setItem(this.ID_TOKEN, JSON.stringify(res));
        if(this.sessaoService.dataUsers().nivel==='ADM'){
          this.router.navigate(['admin']);
          return;
        }
          this.router.navigate(['aluno']);
      }
    });
     
  }

  isLoggedIn() : boolean {
    const localStorageToken = localStorage.getItem(this.ID_TOKEN);
    if (!localStorageToken) {
      return false;
    }
    return true
  }


  logout(): void {
    localStorage.removeItem(this.ID_TOKEN);
    this.router.navigate(['/']);
  }

}

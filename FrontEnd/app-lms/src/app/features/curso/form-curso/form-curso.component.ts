import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { CursoService } from '../../../shared/services/curso.service';
import { Curso } from '../../../shared/model/curso,model';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastService } from '../../../shared/services/toast.service';
import { Observer } from 'rxjs';

@Component({
  selector: 'app-form-curso',
  imports: [CommonModule, MatCardModule, MatButtonModule, ReactiveFormsModule, MatInputModule],
  templateUrl: './form-curso.component.html',
  styleUrl: './form-curso.component.scss'
})
export class FormCursoComponent implements OnInit {
 
  private readonly fb = inject(FormBuilder);
  private readonly cursoservice = inject(CursoService);
  private readonly route = inject(ActivatedRoute);
  private readonly router = inject(Router);
  private readonly toastr = inject(ToastService);

  private id!: number;

  form = this.fb.group({
    id: [''],
    nome: ['', Validators.required],
    descricao: ['', Validators.required]
  });

  ngOnInit(): void {
    this.route.params.subscribe(res => {
      this.id =  res['id'];
      if(this.id){
        this.pesquisarPorId(this.id);
      }
    });
  }

  salvar() {
    if(this.id){
      this.cursoservice.alterar(this.id, this.form.value as Curso).subscribe(
        this.observerPadrao("Curso alterado com sucesso")
      )
      return;
    }
    this.cursoservice.salvar(this.form.value as Curso).subscribe(
      this.observerPadrao("Curso cadastrado com sucesso")
  );
  }
  
  pesquisarPorId(id: number){
    this.cursoservice.buscarPorId(id).subscribe(
        res => this.form.setValue({
          id: res.id !== undefined && res.id !== null ? String(res.id) : null,
          nome: res.nome ?? '',
          descricao: res.descricao ?? ''
        })
      )
  }

observerPadrao<T>(msgSucess: string): Observer<T> {
  return {
    next: (res) => {
      this.toastr.sucess(msgSucess)
      this.router.navigate(['admin']);
    },
    error: (err) => {
      this.toastr.error(err.error.message)
    },
    complete: () => null
  };
}
}

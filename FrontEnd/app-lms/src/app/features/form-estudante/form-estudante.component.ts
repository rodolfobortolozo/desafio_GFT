import { CommonModule, DatePipe, formatDate } from '@angular/common';
import { Component, inject } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {FormBuilder, ReactiveFormsModule, Validators} from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {provideNativeDateAdapter} from '@angular/material/core';
import { EstudanteService } from '../../shared/services/estudante.service';
import { Estudante } from '../../shared/model/estudante.model';
import { ToastService } from '../../shared/services/toast.service';

@Component({
  selector: 'app-form-estudante',
  imports: [CommonModule, MatCardModule, MatButtonModule, ReactiveFormsModule, MatFormFieldModule, MatInputModule, MatDatepickerModule],
providers: [
    provideNativeDateAdapter(),
  ],
  templateUrl: './form-estudante.component.html',
  styleUrl: './form-estudante.component.scss'
})
export class FormEstudanteComponent {

  private readonly fb = inject(FormBuilder);
  private readonly estudanteService = inject(EstudanteService);
  private readonly datePipe = inject(DatePipe);
  private readonly toastr = inject(ToastService)

  
  form = this.fb.group({
    id: [],
    nome: ['', Validators.required],
    sobrenome: ['', Validators.required],
    email: ['', Validators.required],
    dataNascimento: [new Date()],
    telefone: ['', Validators.required],
    senha: ['', Validators.required]
  });

  salvar(){
    const dataNasc = this.form.get('dataNascimento')!.value;
    const estudanteForm = {...this.form.value, dataNascimento : this.datePipe.transform(dataNasc,'dd/MM/YYYY')};

    this.estudanteService.salvar(estudanteForm as Estudante).subscribe({
      next: (res) => {
        this.toastr.sucess("Matriula Efetuada com Sucesso")
        this.form.reset();
      },
      error: (err) => this.toastr.error(err.error.message)
    });
  }

}

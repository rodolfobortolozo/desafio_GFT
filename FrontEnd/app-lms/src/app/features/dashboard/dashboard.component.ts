import { Component } from '@angular/core';
import { FormEstudanteComponent } from '../form-estudante/form-estudante.component';

@Component({
  selector: 'app-dashboard',
  imports: [FormEstudanteComponent],
templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {

}

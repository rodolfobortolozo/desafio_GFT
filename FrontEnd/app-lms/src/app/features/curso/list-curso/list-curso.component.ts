import { Component, inject, OnInit, ViewChild } from '@angular/core';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatSort, MatSortModule} from '@angular/material/sort';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { Curso } from '../../../shared/model/curso,model';
import { CursoService } from './../../../shared/services/curso.service';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';

import {MatIconModule} from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import {MatButtonModule} from '@angular/material/button';
import { roles } from '../../../shared/enum/roles.enum';
import { MatriculaService } from '../../../shared/services/matricula.service';
import { SessaoService } from '../../../arquitetura/service/sessao.service';
import { MatTooltipModule} from '@angular/material/tooltip';
import { ToastService } from '../../../shared/services/toast.service';


@Component({
  selector: 'app-list-curso',
  imports: [MatFormFieldModule, MatInputModule, MatTableModule, MatSortModule, MatPaginatorModule, MatButtonModule, MatDividerModule, MatIconModule, MatTooltipModule, RouterLink],

templateUrl: './list-curso.component.html',
  styleUrl: './list-curso.component.scss'
})
export class ListCursoComponent implements OnInit{

  private readonly cursoService = inject(CursoService);
  private readonly router = inject(Router);
  private readonly route = inject(ActivatedRoute);
  private readonly toastr = inject(ToastService);
  private readonly matriculaService = inject(MatriculaService);
  private readonly sessaoService = inject(SessaoService)

  rolesRoute : roles[] = [];
  rolesEnum = roles;

  displayedColumns: string[] = ['nome', 'descricao', 'acoes'];
  dataSource = new MatTableDataSource<Curso>();;

  ngOnInit(): void {
    const idEstudante = this.sessaoService.getToken()?.id;
    this.cursoService.buscarCursosComMatricula(idEstudante ?? 0).subscribe(
      res => this.dataSource.data = res
      );
    this.route.data.subscribe(res => this.rolesRoute = res['roles'])
  }

  deletar(id: number){
    this.cursoService.excluir(id).subscribe({
      next: () => { 
        this.dataSource.data = this.dataSource.data.filter(d => d.id !=id);
        this.toastr.sucess('Curso deletado com Sucesso');
       },
      error: (err) => this.toastr.error(err.error.message)
    })
  }

  alterar(id: number){
    this.router.navigate(['admin','curso','editar',id]);
  }

  efetuarMatricula(curso : Curso){
    console.log(this.sessaoService.getToken());
    const idEstudante : number = Number(this.sessaoService.dataUsers().id);
    const matricula = {idCurso: curso.id ?? 0, idEstudante: idEstudante}
    
    this.matriculaService.salvar(matricula).subscribe({
      next: () => {
        curso.matriculado = true;
        this.dataSource.data = this.dataSource.data.map(
          c => c === curso ? {...c, matriculado: true} : c
        );
        this.toastr.sucess('Matricula Efetuada com Sucesso');
      },
      error: (err) => this.toastr.error(err.error.message)
    });
  }

}

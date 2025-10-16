import { Routes } from "@angular/router";
import { roles } from "../enum/roles.enum";
import { ListCursoComponent } from "../../features/curso/list-curso/list-curso.component";
import { DashboardAlunoComponent } from "../../features/dashboard-aluno/dashboard-aluno.component";

export const alunoRoutes: Routes = [
  {
      path: '',
      children:[
      {
        path:'',
        component: DashboardAlunoComponent
      }
      ]
  },
  {
    path:'curso',
    children:[
      {
        path: 'listar',
        component : ListCursoComponent,
        data: {
          roles: [roles.ALUNO]
        }
      }
    ]
  },
  
];
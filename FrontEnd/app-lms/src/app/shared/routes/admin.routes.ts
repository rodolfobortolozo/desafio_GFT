import { Routes } from "@angular/router";
import { FormCursoComponent } from "../../features/curso/form-curso/form-curso.component";
import { ListCursoComponent } from "../../features/curso/list-curso/list-curso.component";
import { roles } from "../enum/roles.enum";
import { DashboardAdminComponent } from "../../features/dashboard-admin/dashboard-admin.component";

export const adminRoutes: Routes = [
  {
    path: '',
    children:[
    {
      path:'',
      component: DashboardAdminComponent
    }
    ]
  },
  {
    path:'curso',
    children:[
      {
        path: 'cadastrar',
        component : FormCursoComponent
      },
      {
        path:'editar/:id',
        component : FormCursoComponent
      },
      {
        path: 'listar',
        component : ListCursoComponent,
        data: {
          roles: [roles.ADM]
        }
      }
    ]
  },
  
];
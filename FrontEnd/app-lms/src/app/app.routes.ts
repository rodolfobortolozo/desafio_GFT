import { Routes } from '@angular/router';
import { FormEstudanteComponent } from './features/form-estudante/form-estudante.component';
import { LoginUsuarioComponent } from './features/login-usuario/login-usuario.component';
import { roles } from './shared/enum/roles.enum';
import { canAuthGuard } from './shared/guard/can-auth.guard';
import { DashboardComponent } from './features/dashboard/dashboard.component';
import { AdminPanelComponent } from './features/admin-panel/admin-panel.component';
import { PanelComponent } from './features/panel/panel.component';

export const routes: Routes = [
  {
    path:'',
    component: PanelComponent,
    children:[
      {
        path:'',
        component : DashboardComponent
      }
    ]
  },
  {
    path:'login',
    component : LoginUsuarioComponent
  },
  {
    path:'admin',
    component: AdminPanelComponent,
    loadChildren : () => import('./shared/routes/admin.routes').then( r => r.adminRoutes),
    canActivate: [canAuthGuard],
    data:{
      roles : [roles.ADM]
    }
  },
  {
    path:'aluno',
    component: AdminPanelComponent,
    loadChildren : () => import('./shared/routes/aluno.routes').then( r => r.alunoRoutes),
    canActivate: [canAuthGuard],
    data:{
      roles : [roles.ALUNO]
    }
  }

];

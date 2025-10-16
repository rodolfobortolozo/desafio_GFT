
import { CanActivateFn } from '@angular/router';
import { SessaoService } from '../../arquitetura/service/sessao.service';
import { inject } from '@angular/core';

export const canAuthGuard: CanActivateFn = (route, state) => {
  const sessaoService = inject(SessaoService); 

  const requiredRoles: Array<string> = route.data['roles'];
  console.log(requiredRoles)
  const nivel: string | undefined = sessaoService.getToken()?.nivel;


  return nivel !== undefined && requiredRoles.some(role => role.includes(nivel));
};

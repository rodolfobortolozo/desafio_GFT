import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { SessaoService } from '../../arquitetura/service/sessao.service';

export const tokenInterceptor: HttpInterceptorFn = (req, next) => {
  const sessaoService = inject(SessaoService);

  if (sessaoService.isLoggedIn()) {
      let newRequest = req.clone({
        setHeaders: {
          Authorization: `Bearer ${sessaoService.getToken()?.token}`,
        },
      });
      return next(newRequest);
    }

    return next(req);


};

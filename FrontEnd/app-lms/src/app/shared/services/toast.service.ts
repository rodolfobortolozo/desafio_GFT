import { inject, Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
@Injectable({
  providedIn: 'root'
})
export class ToastService {

  toastr = inject(ToastrService);

  sucess(msg: string){
    this.toastr.success(msg);
  }

  warning(msg: string){
    this.toastr.warning(msg);
  }

  error(msg: string){
    this.toastr.error(msg);
  }
}

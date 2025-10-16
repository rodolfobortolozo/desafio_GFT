import { HttpClient, HttpHeaders } from "@angular/common/http";
import { inject } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "../../../environments/environment";

export abstract class BaseService<T> {
  
  protected http = inject(HttpClient);
  protected baseUrl: string = '';
  protected options!: { headers: HttpHeaders };

  constructor(baseUrl: string, options?: HttpHeaders){
    this.baseUrl = environment.URL_API + baseUrl;

    if(!options){
      this.options = { headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }) };
    } else {
      this.options = { headers: options };
    }
  }

  buscarTodos(): Observable<T[]>{
    return this.http.get<T[]>(this.baseUrl, this.options); 
  } 

  buscarPorId(id: any) {
    return this.http.get<T>(`${this.baseUrl}/${id}`, this.options); 
  }

  salvar(entity: T): Observable<T> {
    return this.http.post<T>(this.baseUrl, entity, this.options)
  }

  alterar(id: any, entity: T): Observable<T> {
    return this.http.put<T>(`${this.baseUrl}/${id}`, entity, this.options)
  }

  excluir(id: any): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`, this.options)
  }
}
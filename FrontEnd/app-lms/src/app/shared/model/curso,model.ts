import { BaseModel } from "../../arquitetura/model/baseModel";

export interface Curso extends BaseModel<number>{

  nome: string,
  descricao: string,
  matriculado: boolean

}
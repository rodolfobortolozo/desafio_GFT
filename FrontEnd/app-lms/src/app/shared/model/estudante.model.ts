import { BaseModel } from "../../arquitetura/model/baseModel";

export interface Estudante extends BaseModel<number> {
  nome: string;
  sobrenome: string;
  email: string;
  dataNascimento: string,
  telefone: string,
  senha: string
}
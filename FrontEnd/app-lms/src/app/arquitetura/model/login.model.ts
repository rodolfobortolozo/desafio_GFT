import { BaseModel } from "./baseModel";

export interface Login extends BaseModel<number> {
    nome?: string;
    usuario?: string;
    senha?: string;
    token?: string;
    nivel?: string;
}
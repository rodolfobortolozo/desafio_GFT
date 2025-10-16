import { Component, inject, OnInit } from '@angular/core';
import { MatToolbar } from "@angular/material/toolbar";
import { SessaoService } from '../../../arquitetura/service/sessao.service';
import { RouterLink } from '@angular/router';
import {MatIconModule} from '@angular/material/icon';
import { MatTooltip } from "@angular/material/tooltip";

@Component({
  selector: 'app-header',
  imports: [MatToolbar, RouterLink, MatIconModule, MatTooltip],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent implements OnInit{


  nome: string = '';

  private readonly sessaoService = inject(SessaoService);

  ngOnInit(): void {
    this.nome = this.sessaoService.dataUsers().nome!;
  }

  isLogged() {
    return this.sessaoService.isLoggedIn();
  }

  logout() {
    this.sessaoService.logout();
  }

}

import { Component } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { FooterComponent } from "../../shared/components/footer/footer.component";
import { HeaderComponent } from "../../shared/components/header/header.component";
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-admin-panel',
  imports: [RouterOutlet, MatToolbarModule, FooterComponent, HeaderComponent],
templateUrl: './admin-panel.component.html',
  styleUrl: './admin-panel.component.scss'
})
export class AdminPanelComponent {

}

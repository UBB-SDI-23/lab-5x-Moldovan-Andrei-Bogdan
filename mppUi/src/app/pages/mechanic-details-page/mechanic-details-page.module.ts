import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MechanicDetailsPageComponent } from './mechanic-details-page/mechanic-details-page.component';
import { MenuModule } from 'src/app/components/menu/menu.module';
import { RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';



@NgModule({
  declarations: [
    MechanicDetailsPageComponent
  ],
  imports: [
    CommonModule,
    MenuModule,
    MatButtonModule,
    RouterModule,
  ],
  exports: [
    MechanicDetailsPageComponent
  ]
})
export class MechanicDetailsPageModule { }

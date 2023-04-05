import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MechanicsPageComponent } from './mechanics-page/mechanics-page.component';
import { MenuModule } from 'src/app/components/menu/menu.module';
import { RouterModule } from '@angular/router';
import { MechanicEntityModule } from 'src/app/components/mechanic-entity/mechanic-entity.module';



@NgModule({
  declarations: [
    MechanicsPageComponent
  ],
  imports: [
    CommonModule,
    MenuModule,
    RouterModule,
    MechanicEntityModule
  ]
})
export class MechanicsPageModule { }

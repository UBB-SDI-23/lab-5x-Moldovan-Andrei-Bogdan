import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MechanicEntityComponent } from './mechanic-entity/mechanic-entity.component';
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button"
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    MechanicEntityComponent
  ],
  imports: [
    CommonModule,
    MatCardModule,
    MatButtonModule,
    RouterModule
  ],
  exports: [
    MechanicEntityComponent
  ]
})
export class MechanicEntityModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MechanicFormComponent } from './mechanic-form/mechanic-form.component';
import { MenuModule } from 'src/app/components/menu/menu.module';
import { RouterModule } from '@angular/router';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';



@NgModule({
  declarations: [
    MechanicFormComponent
  ],
  imports: [
    CommonModule,
    MenuModule,
    RouterModule,
    MatInputModule,
    MatFormFieldModule
  ]
})
export class MechanicFormModule { }

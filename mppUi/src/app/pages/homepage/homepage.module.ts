import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomepageComponent } from './homepage/homepage.component';
import { MenuModule } from 'src/app/components/menu/menu.module';



@NgModule({
  declarations: [
    HomepageComponent
  ],
  imports: [
    CommonModule,
    MenuModule
  ],
  exports: [HomepageComponent]
})
export class HomepageModule { }

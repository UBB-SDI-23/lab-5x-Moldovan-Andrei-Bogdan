import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { HomepageComponent } from './pages/homepage/homepage/homepage.component';
import { MechanicDetailsPageComponent } from './pages/mechanic-details-page/mechanic-details-page/mechanic-details-page.component';
import { MechanicsPageComponent } from './pages/mechanics-page/mechanics-page/mechanics-page.component';
import { CommonModule } from '@angular/common';
import { MechanicFormComponent } from './pages/mechanic-form/mechanic-form/mechanic-form.component';

const routes: Routes = [
  {path: 'home', component: HomepageComponent},
  {path: 'mechanics', component: MechanicsPageComponent},
  {path: 'mechanics/add', component: MechanicFormComponent},
  {path: 'mechanics/:id', component: MechanicDetailsPageComponent},
  {path: 'mechanics/:id/update', component: MechanicFormComponent},
  {path: 'mechanics/update/:id', component: MechanicFormComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'}
];

@NgModule({
  imports: [CommonModule, RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

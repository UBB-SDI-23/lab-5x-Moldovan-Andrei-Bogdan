import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageModule } from './pages/homepage/homepage.module';
import { MechanicsPageModule } from './pages/mechanics-page/mechanics-page.module';
import { HttpClientModule } from '@angular/common/http';
import { MechanicDetailsPageModule } from './pages/mechanic-details-page/mechanic-details-page.module';
import { MenuModule } from './components/menu/menu.module';
import { MechanicEntityModule } from './components/mechanic-entity/mechanic-entity.module';
import { MechanicFormModule } from './pages/mechanic-form/mechanic-form.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    HomepageModule,
    MechanicsPageModule,
    MechanicDetailsPageModule,
    MechanicFormModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

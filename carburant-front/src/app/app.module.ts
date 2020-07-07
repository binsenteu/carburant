import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { StationComponent } from './components/station/station.component';
import { RechercheCodePostalComponent } from './components/recherche-code-postal/recherche-code-postal.component';
import { ListeStationComponent } from './components/liste-station/liste-station.component';
import { UserLocationTestComponent } from './components/user-location-test/user-location-test.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    StationComponent,
    RechercheCodePostalComponent,
    ListeStationComponent,
    UserLocationTestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { StationComponent } from './components/station/station.component';
import { RechercheCodePostalComponent } from './components/recherche-code-postal/recherche-code-postal.component';
import { UserLocationTestComponent } from './components/user-location-test/user-location-test.component';


const routes: Routes = [
  {path:"home", component:HomeComponent},
  {path:"station/rechercher/:id", component: StationComponent},
  {path:"station/zip", component: RechercheCodePostalComponent},
  {path:"location", component: UserLocationTestComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

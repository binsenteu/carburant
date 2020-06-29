import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { StationComponent } from './components/station/station.component';


const routes: Routes = [
  {path:"home", component:HomeComponent},
  {path:"station/:id", component: StationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

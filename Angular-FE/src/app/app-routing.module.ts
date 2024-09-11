import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {UsersComponent} from "./component/users/users.component";
import {UserdetailsComponent} from "./component/userdetails/userdetails.component";
import {CarsComponent} from "./component/cars/cars.component";

const routes: Routes = [
  { path: '', component: CarsComponent },
  { path: 'users', component: UsersComponent },
  { path: 'user/:id', component: UserdetailsComponent },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

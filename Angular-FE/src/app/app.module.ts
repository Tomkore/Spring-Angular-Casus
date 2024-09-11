import {NgModule} from '@angular/core';
import {BrowserModule, provideClientHydration} from '@angular/platform-browser';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {UsersComponent} from './component/users/users.component';
import {UserdetailsComponent} from './component/userdetails/userdetails.component';
import {provideHttpClient, withFetch} from "@angular/common/http";
import {RouterOutlet} from "@angular/router";
import {CommonModule, NgOptimizedImage} from "@angular/common";
import {CarsComponent} from "./component/cars/cars.component";
import {provideAnimationsAsync} from '@angular/platform-browser/animations/async';
import {MatSidenavContainer, MatSidenavModule} from "@angular/material/sidenav";
import {MatCheckbox} from "@angular/material/checkbox";
import {FormsModule} from "@angular/forms";
import {MatButton} from "@angular/material/button";

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    UserdetailsComponent,
    CarsComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    RouterOutlet,
    NgOptimizedImage,
    MatSidenavContainer,
    MatSidenavModule,
    MatCheckbox,
    FormsModule,
    MatButton
  ],
  providers: [
    provideClientHydration(),
    provideHttpClient(withFetch()),
    provideAnimationsAsync(),
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

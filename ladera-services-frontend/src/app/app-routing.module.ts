import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { RoomComponent } from './room/room.component';
import { RoombookingComponent } from './roombooking/roombooking.component';
import { AuthGuard } from './guards/auth.guard';
import { SuccessfulpageComponent } from './successfulpage/successfulpage.component';
import { CreateroomComponent } from './createroom/createroom.component';
import { ProfileComponent } from './profile/profile.component';

const routes: Routes = [
  {path:'',redirectTo:'home',pathMatch:'full'},
  {path: 'home', component: HomeComponent,canActivate : [AuthGuard]},{path: 'login', component: LoginComponent},
  {path: 'register', component: RegistrationComponent},
  {path: 'room', component: RoomComponent, canActivate : [AuthGuard]},
  {path: 'roombooking/:id', component: RoombookingComponent, canActivate : [AuthGuard]},
  {path: 'createroom', component: CreateroomComponent, canActivate : [AuthGuard]},
  {path: 'registerationsuccess', component: SuccessfulpageComponent},
  {path: 'userprofile', component: ProfileComponent}

];
@NgModule({
  imports: [RouterModule.forRoot(
    routes,
    {enableTracing: false}
  )],
  exports: [RouterModule]
})
export class AppRoutingModule { }

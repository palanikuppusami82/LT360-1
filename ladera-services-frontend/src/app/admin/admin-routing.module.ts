import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { TaskComponent } from './task/task.component';
import { AuthGuard } from '../guards/auth.guard';
import { WingallotmentComponent } from './wingallotment/wingallotment.component';
import { AssetmanagmentComponent } from './assetmanagment/assetmanagment.component';
import { AssetComponent } from './asset/assest.component';


const appRoutes: Routes = [
    {
        path: 'admin',
        component: AdminComponent,
        canActivate : [AuthGuard],
        children:[
            {
                path: 'task',
                component: TaskComponent,
                canActivate : [AuthGuard],
              },
              {
                path: 'adminhome',
                component: AdminhomeComponent,
                canActivate : [AuthGuard],
              },
              {
                path: 'wingallotment',
                component: WingallotmentComponent,
                canActivate : [AuthGuard],
              },{
                path: 'assetmanagment',
                component: AssetmanagmentComponent,
                canActivate : [AuthGuard],
              },{
                path: 'createasset',
                component: AssetComponent,
                canActivate : [AuthGuard],
              }
        ]
      }
  ];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes, {enableTracing: false})],
  exports: [RouterModule]
})
export class AdminRoutingModule { }

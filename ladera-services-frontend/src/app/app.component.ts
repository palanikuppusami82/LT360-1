import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from './employee';
import { AuthenticationService } from './services/authentication-service.service';
import { MdbModalRef, MdbModalService } from 'mdb-angular-ui-kit/modal';
import { CreateroomComponent } from './createroom/createroom.component';
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import { BnNgIdleService } from 'bn-ng-idle';
import { CurrentuserserviceService } from './services/currentuserservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ladera-services-frontend';

   declare currentUser: Employee;
   show: boolean = false; 
   role ='role_admin'; 
   modalRef: MdbModalRef<CreateroomComponent> | null = null;
   usernameforlogin
    constructor(
        public router: Router,
        private authenticationService: AuthenticationService, private dialog: MatDialog,private bnIdle: BnNgIdleService,
    private CurrentuserService: CurrentuserserviceService ) {
        this.authenticationService.currentUser.subscribe(x => this.currentUser = x);

        this.bnIdle.startWatching(600).subscribe((res) => {
            if(res) {
                this.authenticationService.logout();
                this.router.navigate(['/login']);
            }
          })
        //  this.usernameforlogin =  CurrentuserService.getCurrentUserValueByProperties("username");
         // console.log(this.usernameforlogin )
    }

    get isAdmin() {
        return this.currentUser && this.currentUser.roles.includes(this.role);
    }

    logout() {
        this.authenticationService.logout();
        this.router.navigate(['/login']);
    }


    openDialog() {

        const dialogConfig = new MatDialogConfig();

        dialogConfig.disableClose = true;
        dialogConfig.autoFocus = true;

        dialogConfig.data = {
            id: 1,
            title: 'Angular For Beginners'
        };

        this.dialog.open(CreateroomComponent, dialogConfig);
    }
    
}

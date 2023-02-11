import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { FormsModule,ReactiveFormsModule  } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RegistrationComponent } from './registration/registration.component';
import { RoomComponent } from './room/room.component';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatGridListModule} from '@angular/material/grid-list';
import { RoombookingComponent } from './roombooking/roombooking.component';
import {MatFormFieldModule, MAT_FORM_FIELD_DEFAULT_OPTIONS} from '@angular/material/form-field';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { NgxMatTimepickerModule } from 'ngx-mat-timepicker';
import { MatTableModule } from '@angular/material/table'  
import { DatePipe } from '@angular/common';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome'
import { AuthGuard } from './guards/auth.guard'; 
import {ErrorInterceptorInterceptor } from '../app/helper/error-interceptor.interceptor';
import { CreateroomComponent } from './createroom/createroom.component';
import {MatDialogModule} from '@angular/material/dialog';
import { MatIconModule } from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import {MatSidenavModule} from '@angular/material/sidenav';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatMenuModule } from '@angular/material/menu';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatListModule } from '@angular/material/list';
import {MatCheckboxModule} from '@angular/material/checkbox'
import { RouterModule, Routes } from '@angular/router';
import {PageNotFoundComponent} from './page-not-found.component';
import { AdminComponent } from './admin/admin.component';
import { AdminRoutingModule } from './admin/admin-routing.module';
import { AdminhomeComponent } from './admin/adminhome/adminhome.component';
import { TaskComponent } from './admin/task/task.component';
import { ToolbarComponent } from './admin/toolbar/toolbar.component';
import { SidenavComponent } from './admin/sidenav/sidenav.component';
import { NgMultiSelectDropDownModule } from "ng-multiselect-dropdown";
import { SuccessfulpageComponent } from './successfulpage/successfulpage.component';
import {MatSelectModule} from '@angular/material/select';
import { IvyCarouselModule } from "angular-responsive-carousel";
import { BnNgIdleService } from 'bn-ng-idle'; 
import { AvatarModule } from 'ngx-avatar';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import { ProfileComponent } from './profile/profile.component';
import { NgApexchartsModule, } from "ng-apexcharts";
import { WingallotmentComponent } from './admin/wingallotment/wingallotment.component';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import { MatInputModule } from '@angular/material/input';
import { NgbDropdownModule } from '@ng-bootstrap/ng-bootstrap';
import { DragDropFileUploadDirective } from './draganddrop/drag-drop-file-upload.directive';
import { LtdraganddropComponent } from './ltdraganddrop/ltdraganddrop.component';
import { AssetmanagmentComponent } from './admin/assetmanagment/assetmanagment.component';
import { MatStepperModule } from '@angular/material/stepper';
import {NgSelectModule} from '@ng-select/ng-select';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FooterComponent,
    LoginComponent,
    RegistrationComponent,
    RoomComponent,
    RoombookingComponent,
    CreateroomComponent,
     AdminhomeComponent,
     TaskComponent,
     PageNotFoundComponent,
     ToolbarComponent,
     SidenavComponent,
     AdminComponent,
     SuccessfulpageComponent,
     ProfileComponent,
     WingallotmentComponent,
     DragDropFileUploadDirective,
     LtdraganddropComponent,
     AssetmanagmentComponent,

  ],
  imports: [
    BrowserModule,
    FontAwesomeModule,
    FormsModule,
    MatStepperModule,
    HttpClientModule,
    AppRoutingModule,
    MatCardModule,
    MatButtonModule,
    MatToolbarModule,
    MatGridListModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    NgbModule,
    NgbDropdownModule,
    BsDatepickerModule,
    BrowserAnimationsModule,
    MatDatepickerModule,
    MatNativeDateModule, 
    NgxMatTimepickerModule,
    MatTableModule,
    FontAwesomeModule,
    MatDialogModule,
    MatToolbarModule,
    MatSidenavModule,
    MatButtonModule,
    MatIconModule,
    MatDividerModule,
    FlexLayoutModule,
    MatProgressSpinnerModule,
    MatMenuModule,
    MatExpansionModule,
    MatListModule,
    MatCheckboxModule,
    RouterModule,
    AdminRoutingModule,MatSelectModule,
    NgMultiSelectDropDownModule.forRoot(),
    IvyCarouselModule,
    AvatarModule,MatProgressBarModule,
    NgApexchartsModule,
    MatAutocompleteModule,
    MatInputModule,
    NgSelectModule,
 
  ],
  bootstrap: [AppComponent],
  providers: [MatDatepickerModule,BnNgIdleService,AdminComponent,
  MatNativeDateModule,DatePipe, AuthGuard, {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptorInterceptor, multi: true},    {provide: MAT_FORM_FIELD_DEFAULT_OPTIONS, useValue: {floatLabel: 'always'}}
],
})
export class AppModule { }

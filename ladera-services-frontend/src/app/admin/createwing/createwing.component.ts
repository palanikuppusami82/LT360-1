import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AbstractControl,FormBuilder, FormGroup,FormControl,  Validators  } from '@angular/forms';
import { WingserviceService } from 'src/app/services/wingservice.service';
import { Wing } from 'src/app/wing';
import { AdminComponent } from '../admin.component';


@Component({
  selector: 'app-createwing',
  templateUrl: './createwing.component.html',
  styleUrls: ['./createwing.component.css']
})
export class CreatewingComponent implements OnInit {

  declare form: FormGroup;
  declare options: FormGroup;
  submitted = false;
  errMessage:string | undefined
  hasError : boolean | undefined
  currentuser: any
  wing = new Wing; 
  constructor(private adminComponent : AdminComponent,
    private service : WingserviceService, public router : Router,private formBuilder:FormBuilder) {
      this.adminComponent.showDashboardComponent=false; 
     }
  wingCreateForm = new FormGroup({
    wingCode: new FormControl(''),
    wingName: new FormControl(''),
    wingCapacity: new FormControl(''),
  });
    
    ngOnInit() {
      
    }
    registerWing(){
      this.submitted = true;
  
      if (this.wingCreateForm.invalid) {
        return;
      }
      this.service.createwing(this.wing);
    }
   
    close() {
    }
    get f(): { [key: string]: AbstractControl } {
      return this.wingCreateForm.controls;
    }

}

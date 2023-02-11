import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AbstractControl,FormBuilder, FormGroup,FormControl,  Validators  } from '@angular/forms';
import { AssetService } from 'src/app/services/asset.service';
import { Asset } from './asset';
import { AdminComponent } from '../admin.component';




@Component({
  selector: 'app-asset',
  templateUrl: './asset.component.html',
  styleUrls: ['./asset.component.css']
})
export class AssetComponent implements OnInit {
  declare form: FormGroup;
  declare options: FormGroup;
  submitted = false;
  errMessage:string | undefined
  hasError : boolean | undefined
  currentuser: any
  asset = new Asset(); 
  constructor(private adminComponent : AdminComponent,
    private service : AssetService, public router : Router,private formBuilder:FormBuilder) {
      this.adminComponent.showDashboardComponent=false;
    
     }
  assetCreateForm = new FormGroup({
    code: new FormControl(''),
    description: new FormControl(''),
    warrantyPeriod : new FormControl(''),
    serialNumber: new FormControl(''),
    brand: new FormControl(''),
    assignedOn:new FormControl(''),
    assetType:new FormControl(''),
    warrantyEndDate: new FormControl('')
  });
    
    ngOnInit() {
      
    }
    registerAsset(){
      this.submitted = true;
  
      if (this.assetCreateForm.invalid) {
        return;
      }
      this.service.createAsset(this.asset);
    }
   
    close() {
    }
    get f(): { [key: string]: AbstractControl } {
      return this.assetCreateForm.controls;
    }
}

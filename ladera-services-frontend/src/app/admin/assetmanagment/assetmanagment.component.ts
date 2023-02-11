import { Component, importProvidersFrom, NgModule, OnInit, ViewEncapsulation } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AdminComponent } from '../admin.component';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';  
import { AssetInfoDeatils } from 'src/app/model/AssetInfoDeatils';
import { AssetService } from 'src/app/services/asset.service';

@Component({
  selector: 'app-assetmanagment',
  templateUrl: './assetmanagment.component.html',
  styleUrls: ['./assetmanagment.component.css'],
	encapsulation: ViewEncapsulation.None,
})

export class AssetmanagmentComponent implements OnInit {

  isLinear = false;  
  firstFormGroup!: FormGroup;  
  secondFormGroup!: FormGroup ;  
  closeResult: string = '';

 assetInfoa:AssetInfoDeatils[] | undefined;
 
   assetInfo:AssetInfoDeatils | undefined;
  constructor(private assestService:AssetService,private adminComponent : AdminComponent,private modalService: NgbModal,private _formBuilder: FormBuilder,){
    this.adminComponent.showDashboardComponent=false; }
    
  ngOnInit(): void {
    this.firstFormGroup = this._formBuilder.group({  
      firstCtrl: ['', Validators.required]  
    });  
    this.secondFormGroup = this._formBuilder.group({  
      secondCtrl: ['', Validators.required]  
    }); 
    this.assestService.getAllAssets().subscribe( (data:any) =>{
      this.assetInfo=data;
    
     }); 
    this.assetInfo = new AssetInfoDeatils("Lt-lap-001","Laptop","Deployed","Asset23443"); 
  }  

  openLg(content) {
		this.modalService.open(content, { size: 'xl' });
	}

}
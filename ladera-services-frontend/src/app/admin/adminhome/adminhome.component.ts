import { Component, OnInit } from '@angular/core';
import { WingserviceService } from 'src/app/services/wingservice.service';
import { Wing } from 'src/app/wing';
import { AdminComponent } from '../admin.component';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit {

  wings: Wing[] = [
  ];
 
  constructor(private adminComponent : AdminComponent,private service : WingserviceService 
    ) { 
      this.adminComponent.showDashboardComponent=false;
    }

  ngOnInit(): void {
    this.service.getAllWings().subscribe( (data:any) =>{
      this.wings=data;
    
     });
  }

}

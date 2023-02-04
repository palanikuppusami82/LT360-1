import { Component, OnInit } from '@angular/core';
import { AdminComponent } from '../admin.component';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit {
 
  constructor(private adminComponent : AdminComponent
    ) { 
      this.adminComponent.showDashboardComponent=false;
    }

  ngOnInit(): void {

  }

}

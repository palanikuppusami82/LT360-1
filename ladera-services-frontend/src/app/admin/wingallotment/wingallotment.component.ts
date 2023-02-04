import { Component, OnInit } from '@angular/core';
import { FormControl} from '@angular/forms';
import { Observable } from 'rxjs';
import { SeatInfo } from 'src/app/model/SeatInfo';
import { WingserviceService } from 'src/app/services/wingservice.service';
import { AdminComponent } from '../admin.component';
import { map, startWith } from 'rxjs/operators';

@Component({
  selector: 'app-wingallotment',
  templateUrl: './wingallotment.component.html',
  styleUrls: ['./wingallotment.component.css']
})
export class WingallotmentComponent implements OnInit {

  employeeDropDown!: any[];
  public slot!: SeatInfo;
  empId!: FormControl;
  ngSeatModel:SeatInfo | undefined;
   map = new Map<string, string>();
   filteredEmployee: Observable<any[]>;

  constructor(private adminComponent : AdminComponent, private wingService:WingserviceService){
    this.adminComponent.showDashboardComponent=false;
    this.empId = new FormControl();
    this.filteredEmployee = this.empId.valueChanges.pipe(
      startWith(''),
      map((employeeId) =>
      employeeId ? this.filterEmployee(employeeId) : this.employeeDropDown.slice()
      )
    );
    
  }

  ngOnInit(): void {
    this.wingService.getSlots('wing7').subscribe((data:any) =>{
     this.slot=data;
     this.map  = this.slot.unAssignedEmployeeMap;
     console.log(this.slot.unAssignedEmployeeMap);
     Object.keys(this.map).forEach( (key) =>{
      var keyvalue = this.map[key]
    this.employeeDropDown.push(keyvalue);
  });
  });  
   
  this.empId.valueChanges.subscribe(value => {
    startWith(''),
    map((value) =>
    value ? this.filterEmployee(value) : this.employeeDropDown.slice()
    )
  });

  }

  get employeeIds(): string[] {
    this.employeeDropDown = Array.from(Object.keys(this.map))
    return this.employeeDropDown
  }
  sample() {
    console.log(this.employeeIds)
  }

  filterEmployee(name) {
    let arr = this.employeeIds.filter(
      (employeeIds) => employeeIds.toLowerCase().indexOf(name.toLowerCase()) === 0
    );

    return arr.length ? arr : [{ name: 'No Item found', code: 'null' }];
  }

  onWriterChange($event){
   console.log($event);
  }

}

import { Component, OnInit } from '@angular/core';
import { FormControl} from '@angular/forms';
import { SeatInfo } from 'src/app/model/SeatInfo';
import { WingserviceService } from 'src/app/services/wingservice.service';
import { AdminComponent } from '../admin.component';
import { AfterViewInit, OnDestroy, ViewChild } from '@angular/core';
import {  ReplaySubject, Subject, take, takeUntil } from 'rxjs';
import { MatInput } from '@angular/material/input';
import { ActivatedRoute } from '@angular/router';

export interface EmployeeContainer {
  employeeCode: string;
}

export interface SeatContainer {
  seatCode: string;
  seatStatus:string;
}

export interface dataContainer {
    columnCode:string
    columnData:SeatContainer[]
}

@Component({
  selector: 'app-wingallotment',
  templateUrl: './wingallotment.component.html',
  styleUrls: ['./wingallotment.component.css']
})
export class WingallotmentComponent implements OnInit, AfterViewInit, OnDestroy {

  selectedEmployee: any;

  public slot!: SeatInfo;
  empId!: FormControl;
   map = new Map<string, string>();
   public banks: EmployeeContainer[] = []
   seatmap = new  Map<string, string>();
   public seats: SeatContainer[] = []
 selectedSeatNumber!:string;
 selectedEmployeeEmail!:string;
 activeSeat
 imageName!: String
 blankEmp!:boolean
 blankSeat!:boolean
 wingCode!:string;

   /** control for the selected bank */
public bankCtrl: FormControl = new FormControl();

/** control for the MatSelect filter keyword */
public bankFilterCtrl: FormControl = new FormControl();

/** list of banks filtered by search keyword */
  public filteredBanks: ReplaySubject<EmployeeContainer[]> = new ReplaySubject<EmployeeContainer[]>(1);

@ViewChild('singleSelect') singleSelect: MatInput | undefined;

/** Subject that emits when the component has been destroyed. */
protected _onDestroy = new Subject<void>();
  constructor(private adminComponent : AdminComponent, private wingService:WingserviceService,private route: ActivatedRoute){
    this.adminComponent.showDashboardComponent=false;
    this.empId = new FormControl();
  }



  ngOnInit(): void {
    let  result : EmployeeContainer[] = [];
    let  seatarray : SeatContainer[] = [];
    this.route.queryParams.subscribe(
      params => {
        this.wingCode =  params['wingCode'];
      }
    )   
    this.wingService.getSlots(this.wingCode).subscribe((data:any) =>{
     this.slot=data;
     this.map  = this.slot.unAssignedEmployeeMap;
     Object.keys(this.map).forEach( (value) =>{
     result.push({employeeCode: value})
     this.banks = result;
     });
     this.seatmap =this.slot.seatNumber;
     for (const [key, value] of Object.entries(this.seatmap)) {
      seatarray.push({
        seatCode: key,
        seatStatus: value,
      })    
    }
    console.log(this.map);
  
      this.seats=seatarray;
      console.log(this.seats);
  });  

 // set initial selection
 this.bankCtrl.setValue(this.banks[10]);

 // load the initial bank list
 this.filteredBanks.next(this.banks.slice());

 // listen for search field value changes
 this.bankFilterCtrl.valueChanges
   .pipe(takeUntil(this._onDestroy))
   .subscribe(() => {
     this.filterBanks();
   });
}
ngAfterViewInit() {
 this.setInitialValue();
}

ngOnDestroy() {
 this._onDestroy.next();
 this._onDestroy.complete();
}

public sample(ind) {
  if(this.seats[ind].seatStatus!=='occupied'){
  if(this.activeSeat===ind){
    this.activeSeat="";
    this.selectedSeatNumber="";
    return;
  }
  this.blankSeat=false;
  this.activeSeat=ind;
  this.selectedSeatNumber = this.seats[ind].seatCode
}
return;
  //this.imageName = "http://localhost:4200/assets/images/selected.png"
}

  /**
 * Sets the initial value after the filteredBanks are loaded initially
 */
protected setInitialValue() {
  this.filteredBanks
    .pipe(take(1), takeUntil(this._onDestroy))
    .subscribe(() => {
      // setting the compareWith property to a comparison function
      // triggers initializing the selection according to the initial value of
      // the form control (i.e. _initializeSelection())
      // this needs to be done after the filteredBanks are loaded initially
      // and after the mat-option elements are available
      //this.singleSelect.compareWith = (a: EmployeeContainer, b: EmployeeContainer) => a && b && a.employeeCode === b.employeeCode;
    });
}

protected filterBanks() {
  if (!this.banks) {
    return;
  }
  // get the search keyword
let search = this.bankFilterCtrl.value;
 
  if (!search) {
    this.filteredBanks.next(this.banks.slice());
    return;
  } else {
    search = search.toLowerCase();
  }
  // filter the banks
  this.filteredBanks.next(
    this.banks.filter(bank => bank.employeeCode.toLowerCase().indexOf(search) > -1)
  );
}
  onChangeEvent(event){
    if(event==undefined){
      this.selectedEmployeeEmail="";
    }
    this.selectedEmployee = event.employeeCode
    for (const [key, value] of Object.entries(this.map)) {
      if (key === this.selectedEmployee) {
        this.selectedEmployeeEmail=value;
      }
    }
  }

  allotSeatForEmployee(){
    if(this.selectedEmployee===undefined || this.selectedEmployee===null){
      this.blankEmp=true;
      return;
    }
    if(this.selectedSeatNumber===undefined||this.selectedSeatNumber===null){
      this.blankSeat=true;
      return;
    }
    this.wingService.allotSlotForEmployee(this.selectedEmployee,this.selectedSeatNumber);
  }

}



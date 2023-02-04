import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Time } from '../model/time';
import { DatePipe, Location } from '@angular/common';
import { Bookedroomentries } from '../model/bookedroomentries.model';
import { RoombookingserviceService } from '../services/roombookingservice.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-roombooking',
  templateUrl: './roombooking.component.html',
  styleUrls: ['./roombooking.component.css']
})
export class RoombookingComponent implements OnInit {
  

  public changedStartTime:string
  public changedEndTime:string
  today=new Date();
  startTime: Time | undefined 
  endTime: Time | undefined 
  model:any;
  submitted = false;
  startDate: Date | undefined;
  desc: string
  emailId: string
  selecteddate: Date ;
  empId:number
  public formIdData : String;
  public option: any = [];
  showTable: boolean = false;
  bookingStartDateTime=new Date();
  bookingEndDateTime=new Date();
  errMessage:string | undefined
  hasError : boolean | undefined
  currentuser: any
  @ViewChild("maindiv") mainDiv: ElementRef | undefined;



  constructor(private router: Router,private location: Location,private formBuilder: FormBuilder, private roombookingserviceService : RoombookingserviceService ) {
    const state = this.location.getState() as {
     roomId:String 
    } 
    this.formIdData = state.roomId;
    }
 
  roomBookingForm = new FormGroup({
    emailId: new FormControl(''),
    discription: new FormControl(''),
    picker : new FormControl(''),
    starttime : new FormControl(''),
    endTime: new FormControl('')
  });

  ngOnInit():  void {
    this.roomBookingForm = this.formBuilder.group(
      {
        emailId: ['', [Validators.required, Validators.email]],
        discription: [
          '',
          [
            Validators.required,
          ],
        ],
        picker:['',Validators.required],
        starttime:['',Validators.required],
        endTime:['',Validators.required]
      }
    );
  } 

  get f(): { [key: string]: AbstractControl } {
    return this.roomBookingForm.controls;
  }
 
  save() {
    this.submitted = true;
    console.log(this.formIdData)
    if(this.formIdData===undefined){
      this.router.navigate(['/room'])
    }
      
    if (this.roomBookingForm.invalid) {
      return;
    }
     this.bookingStartDateTime = this.toTime(this.bookingStartDateTime, this.changedStartTime)
     this.bookingEndDateTime = this.toTime(this.bookingEndDateTime, this.changedEndTime)
       
     if (this.bookingStartDateTime != undefined && this.bookingStartDateTime < new Date()) {
      this.errMessage = 'Start Time should be greater than or equal to current Time.';
      this.hasError = true
      return;
  }
  if (this.bookingEndDateTime != undefined && new Date(this.bookingEndDateTime) < new Date()) {
      this.errMessage = 'End Time should be greater than or equal to current Time.';
      this.hasError = true
      return ;
  }
  if (this.bookingStartDateTime != undefined && this.bookingEndDateTime != undefined  && this.bookingEndDateTime <= this.bookingStartDateTime) {
    this.errMessage = "End Time must be after start Time.";
    this.hasError = true
      return ;
  }
  this.currentuser = JSON.parse(localStorage.getItem('currentUser'));
  this.empId = this.currentuser.id
  this.desc = this.roomBookingForm.get('discription')?.value!;
  this.emailId = this.roomBookingForm.get('emailId')?.value!;
  const roomRequest = new Bookedroomentries(this.formIdData,this.selecteddate,this.changedStartTime,this.changedEndTime,this.desc,this.emailId,this.empId);
  this.roombookingserviceService.bookroom(roomRequest);
}
  dateChangeHandler(date: Date){
    this.selecteddate = date;
    
  }

  onStartTimeChange(value:{hour:string,minute:string}){
    this.changedStartTime=`${value.hour}:${value.minute}`;
    
    if (`${value.minute}` === '0'){ 
      this.changedStartTime=`${value.hour}:00`;
    }
    if(`${value.hour}`==='0'){
      this.changedStartTime=`00:${value.minute}`;
    }
     if(`${value.minute}` !== '0'){
      this.changedStartTime=`${value.hour}:${value.minute}`;
     }
  }
  onEndTimeChange(value:{hour:string,minute:string}){
    this.changedEndTime=`${value.hour}:${value.minute}`;
    if (`${value.minute}` === '0'){ 
      this.changedEndTime=`${value.hour}:00`;
    }
    if(`${value.hour}`==='0'){
      this.changedEndTime=`00:${value.minute}`;
    }
     if(`${value.minute}` !== '0'){
      this.changedEndTime=`${value.hour}:${value.minute}`;
     }
     console.log(this.changedEndTime);
  }


 toTime(date: Date,timeString){
    var timeTokens = timeString.split(':');
    date.setHours(timeTokens[0]);
    date.setMinutes(timeTokens[1])
 return date;
}
carouselImages = [
  {path: 'http://localhost:4200/assets/images/meetingroom-1.jpg'},
  {path: 'http://localhost:4200/assets/images/meetingroom-2.jpg'},
  {path: 'http://localhost:4200/assets/images/meetingroom-3.jpg'},
]

}
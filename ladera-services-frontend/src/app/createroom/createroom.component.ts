import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { AbstractControl,FormBuilder, FormGroup,FormControl,  Validators  } from '@angular/forms';
import { Room } from '../room';
import { RoombookingserviceService } from '../services/roombookingservice.service';
import { WingserviceService } from '../services/wingservice.service';
import { WingSeatAllotment } from '../model/WingSeatAllotment';




@Component({
  selector: 'app-createroom',
  templateUrl: './createroom.component.html',
  styleUrls: ['./createroom.component.css']
})
export class CreateroomComponent implements OnInit {
  declare form: FormGroup;
  declare options: FormGroup;
  submitted = false;
  errMessage:string | undefined
  hasError : boolean | undefined
  currentuser: any
  room = new Room(); 

  constructor(
    private service : RoombookingserviceService, public router : Router,private formBuilder:FormBuilder,private wingService:WingserviceService ) { }
  roomCreateForm = new FormGroup({
    roomId: new FormControl(''),
    roomName: new FormControl(''),
    roomType : new FormControl(''),
    description: new FormControl(''),
    seatCapacity: new FormControl(''),
    additionalFacilities:new FormControl('')
  });
    
    ngOnInit() {
      
    }
    registerRoom(){
      this.submitted = true;
  
      if (this.roomCreateForm.invalid) {
        return;
      }
      this.service.createRoom(this.room);
    }
   
    close() {
    }
    get f(): { [key: string]: AbstractControl } {
      return this.roomCreateForm.controls;
    }
}

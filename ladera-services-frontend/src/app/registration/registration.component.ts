import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { RegistrationService } from '../registration.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Validation from '../utils/validation';
import {AbstractControl,} from '@angular/forms';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  employee = new Employee();
  constructor(private service : RegistrationService, public router : Router,private formBuilder:FormBuilder) { }

  registerForm!: FormGroup;
  submitted = false;
  gendervalues=["MALE","FEMALE"];

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group(
      {
        empId: ['', Validators.required],
        firstName:['', Validators.required],
        lastName:['', Validators.required],
        emailId: ['', [Validators.required, Validators.email]],
        mobileNumber:['', Validators.required],
        gender:['', Validators.required],
        pwd: [
          '',
          [
            Validators.required
          ]
        ],
        cpwd: ['', Validators.required]
      },
      {
        validators: [Validation.match('pwd', 'cpwd')]
      }
    );

  }

  registerEmployee(){
    this.submitted = true;

    if (this.registerForm.invalid) {
      return;
    }
    this.service.registerEmployeeFromRemote(this.employee).subscribe({
      error: () => {
      console.error('exception occured')},
      complete: () => {
        this.router.navigate(['/registerationsuccess']);
      } 
    })
  }
  get f(): { [key: string]: AbstractControl } {
    return this.registerForm.controls;
  }

}

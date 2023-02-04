import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { AuthenticationService } from '../services/authentication-service.service';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  msg="";
    declare loginForm: FormGroup;
    submitted = false;
    declare returnUrl: string;
    error = '';
  public employee = new Employee(); 
  constructor( private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
        username: ['', Validators.required],
        password: ['', Validators.required]
    });
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }
    
  employeeLogin() {
    this.submitted = true;
    
    if (this.loginForm.invalid) {
      return;
    }

    this.authenticationService.login(this.employee.username, this.employee.password)
        .pipe(first())
        .subscribe(
            data => {
               const currentUser = this.authenticationService.currentUserValue;
                if(currentUser.roles && (currentUser.roles.includes("role_admin")||currentUser.roles.includes("role_superadmin"))){
                  this.returnUrl='/admin'
                }
                this.router.navigate([this.returnUrl]);
            },
            error => {
                this.error = error;
            });
}
get f(): { [key: string]: AbstractControl } {
  return this.loginForm.controls;
}

}
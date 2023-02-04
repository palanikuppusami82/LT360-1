import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder,FormControl,FormGroup} from '@angular/forms';
import { Employee } from 'src/app/employee';
import { EmployeeserviceService } from 'src/app/services/employeeservice.service';
import { AdminComponent } from '../admin.component';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  dataSource : any[] = [];
  displayedColumns = ['EmployeeId', 'FirstName', 'EmailId','Roles', 'Is-Active', 'Update'];
  employeeapproval: FormGroup;
  myControls: FormControl[] = [];
  userRolesControls: FormControl[] = [];
  public employee = new Employee(); 

  rolesList = [
    {
      id: 1,
      role: 'role_employee'
    },
    {
      id: 2,
      role: 'role_admin'
    },
    {
      id: 3,
      role: 'role_super_admin'
    }
  ];

  constructor(private employeeserviceService:EmployeeserviceService, private fb:FormBuilder,private adminComponent : AdminComponent){
    this.adminComponent.showDashboardComponent=false;
  }

  ngOnInit() {
   this.employeeserviceService.getAllEmpoyeeForApproval().subscribe( (data:any) =>{
    this.dataSource=data;
    this.dataSource.forEach(data => {
      this.userRolesControls.push(data.empId)
      this.addNewFormControl(data);
    });
   });
 }
 updateEmployee(element,position){
  console.log(element)
  var usermailId = element.emailId;
  this.employee.roles= this.myControls[position].value
  this.employee.isActive = true
  this.employeeserviceService.approveEmployee(usermailId,this.employee) 
}
 
private addNewFormControl(element) {
  const formControl = this.getAutoCompleteFormControl();
  this.myControls.push(formControl);
}



private getAutoCompleteFormControl(): FormControl {
  return new FormControl();
}
 }






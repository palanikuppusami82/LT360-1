import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '@environments/environment';
import { Employee } from '../employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeserviceService {

 declare employees: Employee [];
 currentuser: any
 headers_object:any
 httpOptions:any
  constructor(private http: HttpClient) {
     this.currentuser = JSON.parse(localStorage.getItem('currentUser'));
     this.headers_object = new HttpHeaders().set("Authorization", "Bearer " + this.currentuser.accessToken);
     this.httpOptions = {
      headers: this.headers_object
    };
}

  getAllEmpoyeeForApproval(){ 
      return this.http.get(`${environment.baseurl}api/employee/getpending/user`,this.httpOptions)
}   
    approveEmployee(emailId: string, employeeData){
      return this.http.put<any>(`${environment.baseurl}api/employee/approve/user/${emailId}`,employeeData,this.httpOptions).subscribe();
    }
}

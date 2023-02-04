import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CurrentuserserviceService {

   public currentuser: any
   public headers_object:any
   public httpOptions:any

  constructor(private http: HttpClient) {
    this.currentuser = JSON.parse(localStorage.getItem('currentUser'));

   }


getCurrentUserAuthToken():any{
  this.headers_object = new HttpHeaders().set("Authorization", "Bearer " + this.currentuser.accessToken);
  this.httpOptions = {
   headers: this.headers_object
 }
 return this.httpOptions;
}
// getCurrentUserValueByProperties(property):any{
//   console.log(this.currentuser)
//     if (this.currentuser.hasOwnProperty(property)) {
//        return this.currentuser[property];
//     }
//   }
}

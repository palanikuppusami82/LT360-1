import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '@environments/environment';
import { WingSeatAllotment } from '../model/WingSeatAllotment';

@Injectable({
  providedIn: 'root'
})
export class WingserviceService {

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

createwing(creationRequest:WingSeatAllotment){
  return this.http.post(`${environment.baseurl}api/wings/create`,creationRequest,this.httpOptions).subscribe()
  
}

getSlots(wingCode: string){
  return this.http.get(`${environment.baseurl}api/wings/getwingslot/${wingCode}`,this.httpOptions)
}   

}
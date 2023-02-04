import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from '@environments/environment';
import { Observable } from 'rxjs';
import { Room } from '../room';


@Injectable({
  providedIn: 'root'
})
export class RoombookingserviceService {


  currentuser: any
  headers_object:any
  httpOptions:any
  constructor(private http: HttpClient,public router : Router) {
    this.currentuser = JSON.parse(localStorage.getItem('currentUser'));
    this.headers_object = new HttpHeaders().set("Authorization", "Bearer " + this.currentuser.accessToken);
    this.httpOptions = {
     headers: this.headers_object
   };
}
public createRoom(room :Room){

  return this.http.post(`${environment.baseurl}api/room/createroom`,room,this.httpOptions).subscribe(
    {
      error: () => {
      console.error('exception occured')},
      complete: () => {
        this.router.navigate(['/room']);
      } 
    }
  );
  
}

public getAllRooms(){
  return this.http.get(`${environment.baseurl}api/room/getAllRooms`,this.httpOptions);
}
  bookroom(bookingentries){ 
  return this.http.post(`${environment.baseurl}booking/room`,bookingentries,this.httpOptions).subscribe(
    {
      error: () => {
      console.error('exception occured')},
      complete: () => {
        this.router.navigate(['/registerationsuccess']);
      } 
    }
  );
}   

}

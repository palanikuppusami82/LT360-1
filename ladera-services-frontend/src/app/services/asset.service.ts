import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from '@environments/environment';
import { Observable } from 'rxjs';
import { Asset } from '../admin/asset/asset';


@Injectable({
  providedIn: 'root'
})
export class AssetService {


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
public createAsset(room :Asset){

  return this.http.post(`${environment.baseurl}api/asset/createAsset`,room,this.httpOptions).subscribe(
    {
      error: () => {
      console.error('exception occured')},
      complete: () => {
        this.router.navigate(['/admin/assetmanagment']);
      } 
    }
  );
  
}

public getAllAssets(){
  return this.http.get(`${environment.baseurl}api/room/getAllAsset`,this.httpOptions);
}
 

}

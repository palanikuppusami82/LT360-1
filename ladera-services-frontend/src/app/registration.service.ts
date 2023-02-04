import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';
import { HttpClient } from '@angular/common/http';
import { Room } from './room';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private httpClient: HttpClient) { }
  isAuthenticated :boolean = false;
  public employeeLoginFromRemote(employee :Employee):Observable<any>{

    return this.httpClient.post<any>("http://localhost:8080/ladera/api/auth/signin",employee)
  }
  public registerEmployeeFromRemote(employee :Employee):Observable<any>{

    return this.httpClient.post<any>("http://localhost:8080/ladera/api/auth/signup",employee)
  }

  public createRoom(room :Room):Observable<any>{

    return this.httpClient.post<any>("http://localhost:8080/ladera/room/createroom",room)
  }
  
}

import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { AuthenticationService } from '../services/authentication-service.service';
import { catchError } from 'rxjs/operators';


@Injectable()
export class ErrorInterceptorInterceptor implements HttpInterceptor {

  constructor(private authenticationService: AuthenticationService) { }
  
     error: any;
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
      return next.handle(request).pipe(catchError(err => {
          if ([401, 403].indexOf(err.status) !== -1) {
              this.authenticationService.logout();
               this.error = "Please Enter Valid UserName and Password (or) If You already Registered User, please Contact Admin For approval"
          }
          return throwError(this.error);
      }))
  }
  
}

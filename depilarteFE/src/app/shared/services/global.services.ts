import {Injectable} from '@angular/core';
import {environment} from '../../../environments/environment';
import {Observable, Subject} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class GlobalServices {
  Url = environment.Url;
  private spinnerActive: Subject<boolean> = new Subject<boolean>();
  public spinnerActiveObs = this.spinnerActive.asObservable();

  constructor(private http: HttpClient) {}

  httpServicesResponse(data, service): Observable<any> {
    const url = service;
    let headers: any;
    headers = new HttpHeaders({
      'Content-Type': 'text/json',
      'Accept': 'application/json'
    });
    return this.http.post(url, JSON.stringify(data), {headers: headers});
  }

}

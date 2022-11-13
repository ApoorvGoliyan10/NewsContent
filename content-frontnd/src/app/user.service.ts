import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Logindata } from './logindata';
import { Signupdata } from './signupdata';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  //  http://localhost:64100/usercontent/register
  //localhost:64100/usercontent/register
  usernbaseurl: string = "http://localhost:64100/usercontent";

  registerUser(data: Signupdata) {
    return this.httpClient.post<any>(this.usernbaseurl + "/register", data);
  }

  // http://localhost:64200/userservice/login
  url = "http://localhost:64200/userservice";

  logincheck(data: Logindata) {
    return this.httpClient.post<any>(this.url + "/login", data);
  }


}

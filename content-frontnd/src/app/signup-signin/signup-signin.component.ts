import { Component, OnInit } from '@angular/core';
import { ContentService } from '../content.service';
import { Logindata } from '../logindata';
import { Signupdata } from '../signupdata';
import { UserService } from '../user.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';



@Component({
  selector: 'app-signup-signin',
  templateUrl: './signup-signin.component.html',
  styleUrls: ['./signup-signin.component.css']
})
export class SignupSigninComponent implements OnInit {

  // constructor() { }
  signupdata: Signupdata |any ;
  logindata: Logindata | any;
  
 constructor(private userservice: UserService, private router:Router) {
   window.localStorage.clear();
 }

  ngOnInit(): void {
  }


  // define formgroup to capature shaped


  userFormGroup = new FormGroup({
    emailid: new FormControl('', [Validators.required]),
    username: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required]),
    address: new FormControl('', [Validators.required])
  });


  SignuppData() {
    console.log(this.userFormGroup.value);
    // store form data into model object
    this.signupdata = this.userFormGroup.value;
    console.log(this.signupdata);
    this.userservice.registerUser(this.signupdata).subscribe(
      response => {
        console.log("User registered ");
        // console.log(response);
        confirm("User registration success : ");
      })
  }

  loginFormGroup = new FormGroup({
   // "userid": new FormControl(''),
    "emailid": new FormControl(''),
    "password": new FormControl('')
  });

  loginCheck() {
    window.localStorage.clear();
    console.log(this.loginFormGroup.value);
    this.logindata = this.loginFormGroup.value;
    this.userservice.logincheck(this.logindata).subscribe(
      success => {
        console.log(success);
        this.router.navigateByUrl("/news");
        window.localStorage.setItem('tgt', success.token);
        localStorage.setItem("emailid",this.loginFormGroup.value.emailid);
        alert("login success....welcome");
      },
      error => {
        console.log(error);
        alert("login failed");
      });
   }


}

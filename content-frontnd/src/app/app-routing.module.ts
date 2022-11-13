import { ContentChild, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContentMaterialComponent } from './content-material/content-material.component';
import { SignupSigninComponent } from './signup-signin/signup-signin.component';

const routes: Routes = [
  {path:"",redirectTo:"signup",pathMatch:'full'},
  {path:"signup",component:SignupSigninComponent },
  {path:"news",component:ContentMaterialComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

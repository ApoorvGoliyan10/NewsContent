import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ContentService {

 
  constructor(private httpClient: HttpClient) {
    //window.localStorage.clear();
  }

   url : string="http://localhost:64100/usercontent/";
   reqHeader =new HttpHeaders().set('Authorization','Bearer '+window.localStorage.getItem('tgt'));

  getallcontent(){
    console.log(localStorage.getItem("emailid"));
      return this.httpClient.get<any>(this.url+"get/"+localStorage.getItem("emailid"),{'headers':this.reqHeader});
    }
  
    addcontent(data:any){
      console.log(localStorage.getItem("emailid"));
      return this.httpClient.put<any>(this.url+"add/"+localStorage.getItem("emailid"),data,{'headers':this.reqHeader});
    }

    // http://localhost:64100/usercontent/delete/newsid [delete]

    deleteN(data:any){
      console.log("hello");
      console.log(localStorage.getItem("contentList.newsid"));
      return this.httpClient.delete<any>(this.url+"delete/"+localStorage.getItem("newsid"),data);

    }
}

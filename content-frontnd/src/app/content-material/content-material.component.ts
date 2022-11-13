import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ContentService } from '../content.service';

@Component({
  selector: 'app-content-material',
  templateUrl: './content-material.component.html',
  styleUrls: ['./content-material.component.css']
})
export class ContentMaterialComponent implements OnInit {

  constructor(private contentservice: ContentService) { }

  ngOnInit(): void {
  }

  
  newsdata:any;

  getAllContent(){
    this.contentservice.getallcontent().subscribe(
      result=>{
        this.newsdata=result;
        console.log(result);
      }
    )
  }

  // which module to be impoterted into app.module.ts in order to use FormGroup, FormCotntrol
  addcontent=new FormGroup({
    newsid:new FormControl(''),
    headline:new FormControl(''),
    main:new FormControl(''),
    keyword:new FormControl('')
  });


  addnews:any;
  addContent(){
    this.contentservice.addcontent(this.addcontent.value).subscribe(
      add=>{
        this.addnews=add;
        confirm("News Added");
        console.log(add);
        this.getAllContent();
      }
      
    )
   
  }


  delcontent=new FormGroup({
    newsid:new FormControl('')
  });
    //window.localStorage.clear();
  delete:any;
  deleteContent(){
    confirm("News Deleted");
    this.contentservice.deleteN(this.delcontent.value).subscribe(
      news=>{
            this.delete=news;
            console.log(news);
            this.getAllContent();
            
      }
    )
  }

logout(){
  window.localStorage.clear();
  confirm("Succesfully LogOut")
}

}

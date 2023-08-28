import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerServiceService } from '../customer-service.service';

@Component({
  selector: 'app-updatecategory',
  templateUrl: './updatecategory.component.html',
  styleUrls: ['./updatecategory.component.css']
})
export class UpdatecategoryComponent implements OnInit{
   
  cat_id:any;
  cat_name:any;
  
  
  @ViewChild('updateForm') updateForm: NgForm | undefined;
  constructor(private router:Router, private customerSer:CustomerServiceService, private route:ActivatedRoute){
    this.cat_id = this.route.snapshot.paramMap.get('cat_id');
    this.getCategoryById();
    
  }
  ngOnInit(): void {
  }
  updateCategory(catObj:any){
    this.customerSer.updateCategory(catObj).subscribe((response:any)=>{
      this.router.navigateByUrl("categorytable");
    });
  }
  getCategoryById(){
    this.customerSer.getCategoryById(this.cat_id).subscribe((response:any)=>{
       this.cat_id=this.cat_id;
       this.cat_name=this.cat_name;
      this.updateForm?.setValue(response);
    })
  }


}

import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from '../customer-service.service';

@Component({
  selector: 'app-categorytable',
  templateUrl: './categorytable.component.html',
  styleUrls: ['./categorytable.component.css']
})
export class CategorytableComponent implements OnInit {
  delete:boolean=true;
 category:any;
 constructor(private customerSer:CustomerServiceService){

 }
 ngOnInit(): void {
     this.getAllCategory();
 }
 getAllCategory(){
return this.customerSer.getAllCategory().subscribe((data:any)=>{
 this.category=data;
 console.log(data);
})
 }
 deleteCategory(cat_id:string){
  
    if(!(confirm('Are you sure want to delete this user'))){

    }
   
   else{
     this.customerSer.deleteCategory(cat_id).subscribe((response:string)=>{
       alert(response);
       this.getAllCategory();
     });
   }
 } 

}

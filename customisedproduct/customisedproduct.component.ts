import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from '../customer-service.service';

@Component({
  selector: 'app-customisedproduct',
  templateUrl: './customisedproduct.component.html',
  styleUrls: ['./customisedproduct.component.css']
})
export class CustomisedproductComponent implements OnInit {
  delete:boolean=true;
 cproduct:any;
 constructor(private customerSer:CustomerServiceService){

 }
 ngOnInit(): void {
     this.getAllCProducts();
 }
 getAllCProducts(){
return this.customerSer.getAllCustomisedProduct().subscribe((data:any)=>{
 this.cproduct=data;
 console.log(data);
})
 }
 deleteCProduct(cp_id:string){
  if(!(confirm('Are you sure want to delete this user'))){

  }
   else{
     this.customerSer.deleteCProduct(cp_id).subscribe((response:string)=>{
       alert(response);
       this.getAllCProducts();
     });
   }
 } 

}

import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from '../customer-service.service';

@Component({
  selector: 'app-producttable',
  templateUrl: './producttable.component.html',
  styleUrls: ['./producttable.component.css']
})
export class ProducttableComponent  implements OnInit {
  delete:boolean=true;
 product:any;
 constructor(private customerSer:CustomerServiceService){

 }
 ngOnInit(): void {
     this.getAllProducts();
 }
 getAllProducts(){
return this.customerSer.getAllProducts().subscribe((data:any)=>{
 this.product=data;
 console.log(data);
})
 }
 deleteProduct(p_id:string){
  if(!(confirm('Are you sure want to delete this product'))){
   alert("can't delete this product");
  }
   else{
     this.customerSer.deleteProduct(p_id).subscribe((response:string)=>{
       alert(response);
       this.getAllProducts();
     });
   }
 } 


}

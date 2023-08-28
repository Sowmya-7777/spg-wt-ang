import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from '../customer-service.service';

@Component({
  selector: 'app-ordertable',
  templateUrl: './ordertable.component.html',
  styleUrls: ['./ordertable.component.css']
})
export class OrdertableComponent  implements OnInit {
  delete:boolean=true;
 order:any;
 constructor(private customerSer:CustomerServiceService){

 }
 ngOnInit(): void {
     this.getAllOrders();
 }
 getAllOrders(){
return this.customerSer.getAllOrders().subscribe((data:any)=>{
 this.order=data;
 console.log(data);
})
 }
 deleteOrder(o_id:string){
  if(!(confirm('Are you sure want to delete this user'))){

  }
   else{
     this.customerSer.deleteOrder(o_id).subscribe((response:string)=>{
       alert(response);
       this.getAllOrders();
     });
   }

  }
}

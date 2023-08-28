import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from '../customer-service.service';

@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.css']
})
export class CustomersListComponent  implements OnInit {
   delete:boolean=true;
  customer:any;
  constructor(private customerSer:CustomerServiceService){

  }
  ngOnInit(): void {
      this.getAllUsers();
  }
  getAllUsers(){
return this.customerSer.getAllCustomer().subscribe((data:any)=>{
  this.customer=data;
  console.log(data);
})
  }
  deleteUser(cId:string){
    if(!(confirm('Are you sure want to delete this user'))){

    }
    else{
      this.customerSer.deleteCustomer(cId).subscribe((response:string)=>{
        alert(response);
        this.getAllUsers();
      });
    }
  } 

}

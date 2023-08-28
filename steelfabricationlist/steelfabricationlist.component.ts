import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomersListComponent } from '../customers-list/customers-list.component';
import { CustomerServiceService } from '../customer-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-steelfabricationlist',
  templateUrl: './steelfabricationlist.component.html',
  styleUrls: ['./steelfabricationlist.component.css']
})
export class SteelfabricationlistComponent implements OnInit{
  
  customer: Customer= new Customer();
  product:any;
  productlist: any;
  p_id:any;

  constructor(private custSer:CustomerServiceService, private router:Router, private route:ActivatedRoute){

  }
ngOnInit(): void {
   this.getAllProducts(); 
     }

     getAllProducts(){
       this.custSer.getAllProducts().subscribe((data:any)=>{
        this.product=data;
        console.log(data);
       })
     }
}

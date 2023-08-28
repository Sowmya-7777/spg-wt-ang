import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerServiceService } from '../customer-service.service';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit{
  p_id:any;
  p_name:any;
  p_thunmnail:any;
  p_price:any;
  p_details:any;
  p_quantity:any;
  cat_id:any;
  
  constructor(private router:Router, private custSer:CustomerServiceService){ }
  ngOnInit(): void {
    
    
  }
  addProduct(addForm:any){
    console.log(addForm);
    this.custSer.createProduct(addForm).subscribe((response:any)=>{
      setTimeout(()=>{
        this.router.navigateByUrl('producttable');
      }, 1000);
    });
    this.p_id=this.p_id;
    this.p_name=this.p_name;
    this.p_thunmnail=this.p_thunmnail;
    this.p_price=this.p_price;
    this.p_details=this.p_details;
     this.p_quantity=this.p_quantity;
     this.cat_id=this.cat_id;
  }
    
}

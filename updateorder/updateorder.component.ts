import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerServiceService } from '../customer-service.service';

@Component({
  selector: 'app-updateorder',
  templateUrl: './updateorder.component.html',
  styleUrls: ['./updateorder.component.css']
})
export class UpdateorderComponent implements OnInit{
   
  o_id:any;
  p_id:any;
  p_quantity:any;
  s_id:any;
  o_date:any;
  status:any;
  o_delivery:any;

  @ViewChild('updateForm') updateForm: NgForm | undefined;
  constructor(private router:Router, private customerSer:CustomerServiceService, private route:ActivatedRoute){
    this.o_id = this.route.snapshot.paramMap.get('o_id');
    this.getOrderById();
    
  }
  ngOnInit(): void {
  }
  updateOrder(orderObj:any){
    this.customerSer.updateOrder(orderObj).subscribe((response:any)=>{
      this.router.navigateByUrl("ordertable");
    });
  }
  getOrderById(){
    this.customerSer.getOrderById(this.o_id).subscribe((response:any)=>{
     this.o_id=this.o_id;
     this.p_id=this.p_id;
     this.p_quantity=this.p_quantity;
     this.s_id=this.s_id;
     this.o_date=this.o_date;
     this.o_delivery=this.o_delivery;
      this.updateForm?.setValue(response);
    })
  }

}

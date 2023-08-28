import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerServiceService } from '../customer-service.service';

@Component({
  selector: 'app-updatecustomer',
  templateUrl: './updatecustomer.component.html',
  styleUrls: ['./updatecustomer.component.css']
})
export class UpdatecustomerComponent implements OnInit{

  cId:any;
  cName:any;
  cPassword:any;
 cPhone:any;
  email:any;
  cBirth:any;
  cBalance:any;
  cStreet:any;
  cArea:any;
  @ViewChild('updateForm') updateForm: NgForm | undefined;
  constructor(private router:Router, private customerSer:CustomerServiceService, private route:ActivatedRoute){
    this.cId = this.route.snapshot.paramMap.get('cId');
    this.getUserById();
  }
  ngOnInit(): void {
  }
  updateCustomer(customerObj:any){
    console.log(customerObj);
     //this.customerSer.setIsUserLoggedIn();
    this.customerSer.updateCustomer(customerObj).subscribe((response:any)=> {
      this.router.navigateByUrl("customerlist");
    });
  }
  getUserById(){
    this.customerSer.getCustomerById(this.cId).subscribe((response:any)=>{
    //  this.cId=this.cId;
    //  this.cName=this.cName;
    //  this.email=this.email;
    //  this.cPassword=this.cPassword;
    //  this.cBirth=this.cBirth;
    //  this.cBalance=this.cBalance;
      this.updateForm?.setValue(response);
    })
  }

}

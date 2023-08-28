import { Component, OnInit, ViewChild } from '@angular/core';
import { CustomerServiceService } from '../customer-service.service';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-updatecustomised',
  templateUrl: './updatecustomised.component.html',
  styleUrls: ['./updatecustomised.component.css']
})
export class UpdatecustomisedComponent implements OnInit{
   
  cp_id:any;
  budget:any;
  price:any;
  description:any;
  thumbnail:any;
  c_id:any;

  @ViewChild('updateForm') updateForm: NgForm | undefined;
  constructor(private router:Router, private customerSer:CustomerServiceService, private route:ActivatedRoute){
    this.cp_id = this.route.snapshot.paramMap.get('cp_id');
    this.getCProductById();
    
  }
  ngOnInit(): void {
  }
  updateCProduct(proObj:any){
    this.customerSer.updateCProduct(proObj).subscribe((response:any)=>{
      this.router.navigateByUrl("customisedproduct");
    });
  }
  getCProductById(){
    this.customerSer.getCProductById(this.cp_id).subscribe((response:any)=>{
     
      this.updateForm?.setValue(response);
    })
  }
}

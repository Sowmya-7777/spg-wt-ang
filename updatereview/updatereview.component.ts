import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CustomerServiceService } from '../customer-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-updatereview',
  templateUrl: './updatereview.component.html',
  styleUrls: ['./updatereview.component.css']
})
export class UpdatereviewComponent implements OnInit{
   
  r_id:any;
  p_id:any;
  r_desc:any;
  r_starsp_quantity:any;
  c_id:any;
  
  @ViewChild('updateForm') updateForm: NgForm | undefined;
  constructor(private router:Router, private customerSer:CustomerServiceService, private route:ActivatedRoute){
    this.r_id = this.route.snapshot.paramMap.get('r_id');
    this.getReviewById();
    
  }
  ngOnInit(): void {
  }
  updateReview(proObj:any){
    this.customerSer.updateReview(proObj).subscribe((response:any)=>{
      this.router.navigateByUrl("reviewtable");
    });
  }
  getReviewById(){
    this.customerSer.getReviewById(this.r_id).subscribe((response:any)=>{
      
      this.updateForm?.setValue(response);
    })
  }

}

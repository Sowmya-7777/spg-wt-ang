import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from '../customer-service.service';

@Component({
  selector: 'app-reviewtable',
  templateUrl: './reviewtable.component.html',
  styleUrls: ['./reviewtable.component.css']
})
export class ReviewtableComponent implements OnInit {
  delete:boolean=true;
 review:any;
 constructor(private customerSer:CustomerServiceService){

 }
 ngOnInit(): void {
     this.getAllReviews();
 }
 getAllReviews(){
return this.customerSer.getAllReviews().subscribe((data:any)=>{
 this.review=data;
 console.log(data);
})
 }
 deleteReview(r_id:string){
  if(!(confirm('Are you sure want to delete this user'))){

  }
   else{
     this.customerSer.deleteReview(r_id).subscribe((response:string)=>{
       alert(response);
       this.getAllReviews();
     });
   }
 } 

}

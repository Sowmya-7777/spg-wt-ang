import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from '../customer-service.service';

@Component({
  selector: 'app-stafftable',
  templateUrl: './stafftable.component.html',
  styleUrls: ['./stafftable.component.css']
})
export class StafftableComponent implements OnInit {
  delete:boolean=true;
 staff:any;
 constructor(private customerSer:CustomerServiceService){

 }
 ngOnInit(): void {
     this.getAllStaff();
 }
 getAllStaff(){
return this.customerSer.getAllStaff().subscribe((data:any)=>{
 this.staff=data;
 console.log(data);
})
 }
 deleteStaff(s_id:string){
  if(!(confirm('Are you sure want to delete this user'))){

  }
   else{
     this.customerSer.deleteStaff(s_id).subscribe((response:string)=>{
       alert(response);
       this.getAllStaff();
     });
   }
 }

}

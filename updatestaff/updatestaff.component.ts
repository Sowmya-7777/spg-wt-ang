import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerServiceService } from '../customer-service.service';

@Component({
  selector: 'app-updatestaff',
  templateUrl: './updatestaff.component.html',
  styleUrls: ['./updatestaff.component.css']
})
export class UpdatestaffComponent implements OnInit{
   
  s_id:any;
  firstName:any;
  lastName:any;
  phone:any;
  email:any;
  password:any;
  role:any;

  @ViewChild('updateForm') updateForm: NgForm | undefined;
  constructor(private router:Router, private customerSer:CustomerServiceService, private route:ActivatedRoute){
    this.s_id = this.route.snapshot.paramMap.get('s_id');
    this.getStaffById();
    
  }
  ngOnInit(): void {
  }
  updateStaff(staffObj:any){
    this.customerSer.updateStaff(staffObj).subscribe((response:any)=>{
      this.router.navigateByUrl("stafftable");
    });
  }
  getStaffById(){
    this.customerSer.getStaffById(this.s_id).subscribe((response:any)=>{
     
      this.updateForm?.setValue(response);
    })
  }

}

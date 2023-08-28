import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerServiceService } from '../customer-service.service';

@Component({
  selector: 'app-userpage',
  templateUrl: './userpage.component.html',
  styleUrls: ['./userpage.component.css']
})
export class UserpageComponent implements OnInit{
  
  ngOnInit(): void {
   
  }
  constructor(private route:Router, private custSer:CustomerServiceService){

  }
  productlist(){
    this.route.navigateByUrl("/steelfabricationlist");
  }
}

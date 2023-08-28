import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerServiceService } from '../customer-service.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
email:any;
password:any;
un:any;
pwd:any;
customer:Customer[]=[];

constructor(private snak:MatSnackBar, private customerSer: CustomerServiceService, private route:Router){

}

  ngOnInit(): void {
  }

  formSubmit(loginForm:any){

       if(loginForm.un=='admin@gmail.com' && loginForm.pwd=='Password123'){

        this.route.navigateByUrl('adminpage')
       }
       else{
        this.route.navigateByUrl('steelfabricationlist');
       }
      }

    }
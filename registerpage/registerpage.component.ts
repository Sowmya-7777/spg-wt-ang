import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { Router } from '@angular/router';
import { CustomerServiceService } from '../customer-service.service';
import { User } from '../user';


@Component({
  selector: 'app-registerpage',
  templateUrl: './registerpage.component.html',
  styleUrls: ['./registerpage.component.css']
})
export class RegisterpageComponent  implements OnInit{

 userObj: Customer = new Customer();
//userObj:User = new User();
onSuccess:boolean=false;
constructor(private router:Router, private customerSer:CustomerServiceService){}

  ngOnInit(): void {}

  formSubmit(){
    console.log(this.userObj);
    if(this.userObj.cName && this.userObj.cArea && this.userObj.email && this.userObj.cPassword && this.userObj.cPhone  && this.userObj.cCity && this.userObj.cBirth){
      this.customerSer.createCustomer(this.userObj).subscribe((data:any)=>{
        if(data=="Success"){
          alert("success");
          setTimeout(()=>{
             this.onSuccess=false;
             this.router.navigateByUrl('login');
          }, 500);
          }
          else{
            alert(data);
          }
          console.log(this.userObj);
        },
        (error)=>{
          console.log(error);
          alert(error.message);
        });
      
    }
    else{
      alert("please fill all the fields...");
      setTimeout(() =>{

      },400);
    }

  }
  onSubmit(){
    console.log(this.userObj);
    this.formSubmit();
  }
}


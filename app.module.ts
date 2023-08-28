import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { HttpClientModule } from '@angular/common/http';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { AdminpageComponent } from './adminpage/adminpage.component';
import { UserpageComponent } from './userpage/userpage.component';
import { FormsModule } from '@angular/forms';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { RegisterpageComponent } from './registerpage/registerpage.component';
import { CustomersListComponent } from './customers-list/customers-list.component';
import { UpdatecustomerComponent } from './updatecustomer/updatecustomer.component';
import { ProducttableComponent } from './producttable/producttable.component';
import { UpdateproductComponent } from './updateproduct/updateproduct.component';
import { OrdertableComponent } from './ordertable/ordertable.component';
import { UpdateorderComponent } from './updateorder/updateorder.component';
import { ReviewtableComponent } from './reviewtable/reviewtable.component';
import { UpdatereviewComponent } from './updatereview/updatereview.component';
import { CategorytableComponent } from './categorytable/categorytable.component';
import { UpdatecategoryComponent } from './updatecategory/updatecategory.component';
import { CustomisedproductComponent } from './customisedproduct/customisedproduct.component';
import { UpdatecustomisedComponent } from './updatecustomised/updatecustomised.component';
import { StafftableComponent } from './stafftable/stafftable.component';
import { UpdatestaffComponent } from './updatestaff/updatestaff.component';
import { SteelfabricationlistComponent } from './steelfabricationlist/steelfabricationlist.component';
import { AddproductComponent } from './addproduct/addproduct.component';
import { PaymentComponent } from './payment/payment.component';
const routes:Routes=[
  {path:"login",component:LoginComponent},
  {path:"adminpage",component:AdminpageComponent},
  {path:"userpage",component:UserpageComponent},
  {path:"",component:RegisterpageComponent},
  {path:"customerlist",component:CustomersListComponent},
  {path:"updatecustomer/:cId",component:UpdatecustomerComponent},
  {path:"producttable",component:ProducttableComponent},
  {path:"updateproduct/:p_id", component:UpdateproductComponent},
  {path:"categorytable",component:CategorytableComponent},
  {path:"updatecategory/:c_id",component:UpdatecategoryComponent},
  {path:"customisedproduct",component:CustomisedproductComponent},
  {path:"updatecustomised/:cp_id",component:UpdatecustomisedComponent},
  {path:"ordertable",component:OrdertableComponent},
  {path:"updateorder/:o_id",component:UpdateorderComponent},
  {path:"reviewtable",component:ReviewtableComponent},
  {path:"updatereview/:r_id",component:UpdatereviewComponent},
  {path:"stafftable",component:StafftableComponent},
  {path:"updatestaff/:s_id",component:UpdatestaffComponent},
  {path:"steelfabricationlist",component:SteelfabricationlistComponent},
  {path:"addproduct",component:AddproductComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminpageComponent,
    UserpageComponent,
    RegisterpageComponent,
    CustomersListComponent,
    UpdatecustomerComponent,
    ProducttableComponent,
    UpdateproductComponent,
    OrdertableComponent,
    UpdateorderComponent,
    ReviewtableComponent,
    UpdatereviewComponent,
    CategorytableComponent,
    UpdatecategoryComponent,
    CustomisedproductComponent,
    UpdatecustomisedComponent,
    StafftableComponent,
    UpdatestaffComponent,
    SteelfabricationlistComponent,
    AddproductComponent,
    PaymentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatButtonModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule, 
    RouterModule.forRoot(routes, {useHash:true}),
    MatToolbarModule,
    MatIconModule,
    MatFormFieldModule,
    MatSnackBarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

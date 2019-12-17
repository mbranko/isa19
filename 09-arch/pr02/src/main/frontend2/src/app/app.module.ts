import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatCommonModule, MatRippleModule } from '@angular/material/core';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import { MatListModule } from '@angular/material/list';
import { MatInputModule } from '@angular/material/input';
import { MatDialogModule } from '@angular/material/dialog';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { CategoryListComponent } from './category-list/category-list.component';
import { CategoryComponent } from './category/category.component';
import { ProductComponent } from './product/product.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { PaymentComponent } from './payment/payment.component';
import { BreadcrumbComponent } from './breadcrumb/breadcrumb.component';
import { AddProductDialog } from './add-product-dialog/add-product-dialog.component';


@NgModule({
  declarations: [
    AppComponent,
    CategoryListComponent,
    CategoryComponent,
    ProductComponent,
    ShoppingCartComponent,
    PaymentComponent,
    BreadcrumbComponent,
    AddProductDialog,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    MatCommonModule,
    MatRippleModule,
    MatSidenavModule,
    MatToolbarModule,
    MatCardModule,
    MatListModule,
    MatInputModule,
    MatDialogModule,
    AppRoutingModule,
  ],
  providers: [],
  entryComponents: [AddProductDialog],
  bootstrap: [AppComponent]
})
export class AppModule { }

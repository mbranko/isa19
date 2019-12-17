import { Component, SimpleChanges, OnInit } from '@angular/core';
import { PurchaseOrder, OrderItem } from '../models';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  shoppingCart: PurchaseOrder;

  constructor() { }

  ngOnInit() {
    let s = sessionStorage.getItem('shoppingCart');
    this.shoppingCart = JSON.parse(s);
  }

  getTotal():number {
    let sum: number = 0;
    for (let item of this.shoppingCart.items) {
      sum += item.product.price * item.quantity;
    }
    return sum;
  }

  clear() {
    this.shoppingCart = null;
    sessionStorage.removeItem('shoppingCart');
  }

}

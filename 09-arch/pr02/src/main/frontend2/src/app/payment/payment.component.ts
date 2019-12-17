import { Component, OnInit } from '@angular/core';
import { CreditCard, PurchaseOrder } from '../models';
import { PaymentService } from '../services/PaymentService';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css'],
  providers: [PaymentService],
})
export class PaymentComponent implements OnInit {

  card: CreditCard;
  formStatus: string;

  constructor(private paymentService: PaymentService) { }

  ngOnInit() {
    this.card = new CreditCard('4200123412341234', 'Branko Milosavljevic', 12, 20, 123);
    this.formStatus = 'entry';
  }

  paymentSuccessful() {
    this.formStatus = 'success';
    sessionStorage.removeItem('shoppingCart');
  }

  paymentFailed() {
    this.formStatus = 'fail';
  }

  submit() {
    let sc = sessionStorage.getItem('shoppingCart');
    if (sc == null)
      return;
    let shoppingCart: PurchaseOrder = JSON.parse(sc);
    this.formStatus = 'sending';
    this.paymentService.makePayment(shoppingCart, this.card).subscribe(obj => this.paymentSuccessful());
  }

}

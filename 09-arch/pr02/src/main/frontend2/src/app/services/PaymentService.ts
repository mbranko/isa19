import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { CreditCard, PurchaseOrder } from '../models';

@Injectable()
export class PaymentService {

  private paymentUrl: string = 'http://localhost:4567/api/payment';

  constructor(private http: HttpClient) { }

  makePayment(order: PurchaseOrder, card: CreditCard) {
    let request = { order: { items: [] }, card: card };
    for(let item of order.items) {
      request.order.items.push({ product: { id: item.product.id }, quantity: item.quantity})
    }
    return this.http.post(this.paymentUrl, JSON.stringify(request));
  }

}

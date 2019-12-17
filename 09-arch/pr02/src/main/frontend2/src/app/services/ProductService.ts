import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
// import 'rxjs/add/operator/catch';
// import 'rxjs/add/operator/map';

import { Product, Category } from '../models';

@Injectable()
export class ProductService {

  private productUrl: string = 'http://localhost:4567/api/product';

  constructor(private http: HttpClient) { }

  getProduct(id: number) {
    return this.http.get(this.productUrl + '/' + id);//.map(this.extractProduct).catch(this.handleError);
  }

  // private extractProduct(res: HttpResponse) {
  //   let body = res.json();
  //   return body || { };
  // }
  //
  // private handleError(error: HttpResponse | any) {
  //   let errMsg: string;
  //   if (error instanceof HttpResponse) {
  //     const body = error.json() || '';
  //     const err = body.error || JSON.stringify(body);
  //     errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
  //   } else {
  //     errMsg = error.message ? error.message : error.toString();
  //   }
  //   console.error(errMsg);
  //   return Observable.throw(errMsg);
  // }

}

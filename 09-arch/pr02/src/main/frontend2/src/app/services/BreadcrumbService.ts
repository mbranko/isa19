import { Injectable } from '@angular/core';
import { HttpClient, } from '@angular/common/http';

@Injectable()
export class BreadcrumbService {

  private productBreadcrumbUrl: string = 'http://localhost:4567/api/breadcrumb/product';
  private categoryBreadcrumbUrl: string = 'http://localhost:4567/api/breadcrumb/category';

  constructor(private http: HttpClient) { }

  getProductBreadcrumbs(id: number) {
    return this.http.get(this.productBreadcrumbUrl + '/' + id);
  }

  getCategoryBreadcrumbs(id: number) {
    return this.http.get(this.categoryBreadcrumbUrl + '/' + id);
  }

}

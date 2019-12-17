import { Component, OnInit, Input, SimpleChanges } from '@angular/core';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { Observable } from 'rxjs';

import { Category, Product } from '../models';
import { BreadcrumbService } from '../services/BreadcrumbService';

@Component({
  selector: 'app-breadcrumb',
  templateUrl: './breadcrumb.component.html',
  styleUrls: ['./breadcrumb.component.css'],
  providers: [BreadcrumbService],
})
export class BreadcrumbComponent {

  @Input() product: Product;
  @Input() category: Category;
  breadcrumbs: Observable<Object>;

  constructor(private breadcrumbService: BreadcrumbService) { }

  ngOnChanges(simpleChanges: SimpleChanges) {
    this.breadcrumbs = this.getBreadcrumbs();
  }

  getBreadcrumbs() {
    if (this.product) {
      return this.breadcrumbService.getProductBreadcrumbs(this.product.id);
    } else if (this.category) {
      return this.breadcrumbService.getCategoryBreadcrumbs(this.category.id);
    }
  }

}

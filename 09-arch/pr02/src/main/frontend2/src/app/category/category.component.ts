import { Component, OnInit, AfterViewInit } from '@angular/core';
import { ActivatedRoute, Router, Params } from '@angular/router';

import { Category, Product } from '../models';
import { CategoryService } from '../services/CategoryService';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css'],
  providers: [CategoryService],
})
export class CategoryComponent implements OnInit, AfterViewInit {

  category: Category;

  constructor(
    private categoryService: CategoryService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.categoryService.getCategory(+params.get("id")).subscribe((value: Category) => { this.category = value});
    });
  }

  ngAfterViewInit() {
  }

  onSelectCategory(category: Category) {
    this.router.navigate(['/category', category.id]);
  }

  onSelectProduct(product: Product) {
    this.router.navigate(['/product', product.id]);
  }


}

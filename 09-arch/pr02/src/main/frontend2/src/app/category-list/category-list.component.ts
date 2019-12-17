import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';

import { Category } from '../models';
import { CategoryService } from '../services/CategoryService';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css'],
  providers: [CategoryService],
})
export class CategoryListComponent implements OnInit {

  rootCategories: Observable<Object>;
  category: Category;
  selectedId: number;

  constructor(
    private categoryService: CategoryService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.getRootCategories();
  }

  getRootCategories() {
    this.rootCategories = this.categoryService.getRootCategories();
  }

  onSelect(category: Category) {
    this.selectedId = category.id;
    this.router.navigate(['/category', category.id]);
  }

  isSelected(category: Category) {
    return category.id === this.selectedId;
  }

}

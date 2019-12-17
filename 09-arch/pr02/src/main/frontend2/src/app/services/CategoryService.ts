import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Category} from "../models";

@Injectable()
export class CategoryService {

  private rootCategoriesUrl: string = 'http://localhost:4567/api/rootCategories';
  private categoryUrl: string = 'http://localhost:4567/api/category/';

  constructor(private http: HttpClient) { }

  getRootCategories() {
    return this.http.get<Category[]>(this.rootCategoriesUrl);
  }

  getCategory(id: number) {
    return this.http.get<Category>(this.categoryUrl + id);
  }

}

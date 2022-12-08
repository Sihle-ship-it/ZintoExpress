import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../Models/Product';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }
  private ProductsUrl = "https://fakestoreapi.com/products";

  getProducts():Observable<Product[]>{
    return this.http.get<Product[]>(this.ProductsUrl);
  }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Product } from '../Models/Product';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }
  private ProductsUrl = "https://fakestoreapi.com/products";


  // Get list of products
  getProducts():Observable<Product[]>{
    return this.http.get<Product[]>(this.ProductsUrl)
    .pipe(
      catchError(err => {
        console.log('Error caught in API Service');
        console.error(err);
        return throwError(err);
      })
    )
  }
}

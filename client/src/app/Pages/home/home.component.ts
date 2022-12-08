import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/Models/Product';
import { ApiService } from 'src/app/Services/api.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  public products: Product[]  = [];

  constructor(private apiService: ApiService){}

  ngOnInit(): void{
    this.getProducts();
  }


  getProducts(){
    this.apiService.getProducts().subscribe( data =>
      this.products =  data
    );
  }
}

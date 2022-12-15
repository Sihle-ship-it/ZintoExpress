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
  private dbProduct = {};
  constructor(private apiService: ApiService){}

  ngOnInit(): void{
    
    this.getProducts();
    
  }


  //Get product from api
  getProducts(){ //To be executed by admin only.
    this.apiService.getProducts().subscribe( async data => {
      this.products =  await data;
      this.toDb(this.products);
    });
    
  }

  //Save Products to DB
  toDb(p: any){ //To be executed by admin only
    let pd = [];
    for(let i = 0; i < p.length; i++){
      this.dbProduct = {
        id: p[i].id,
        title: p[i].title,
        price: p[i].price,
        description: p[i].description,
        category: p[i].category,
        image: p[i].image,
        rate: p[i].rating.rate,
        count: p[i].rating.count,
        quantity: 0
      }
      pd.push(this.dbProduct)
    }
    
    this.apiService.saveProducts(pd).subscribe(data => {
      console.log(data);
    })
  }

}

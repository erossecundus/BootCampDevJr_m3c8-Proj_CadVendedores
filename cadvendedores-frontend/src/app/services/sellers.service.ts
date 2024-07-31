import { Injectable } from '@angular/core';
import { Seller } from '../interfaces/Seller';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SellersService {

  // sellers : Seller[] = [
  //   {id:1, name:"João", salary:1500.50, bonus:10, gender:1},
  //   {id:2, name:"Maria", salary:1800.50, bonus:20.55, gender:2},
  //   {id:3, name:"Darcy", salary:2000.50, bonus:25.5, gender:3}
  // ];

  genders: string[] = [
    "Masculino",
    "Feminino",
    "Não Informado"
  ];

  constructor(private http: HttpClient) { }

  getGenders(): string[] {
    return this.genders;
  }

  getSellers(): Observable<Seller[]> {
    return this.http.get<Seller[]>("http://localhost:8080/sellers");
  }
  
  save(seller: Seller) {
    return this.http.post<Seller>("http://localhost:8080/sellers", seller);
  }

}

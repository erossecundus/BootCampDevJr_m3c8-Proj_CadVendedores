import { Injectable } from '@angular/core';
import { Seller } from '../interfaces/Seller';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SellersService {

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

  update(seller: Seller) {
    return this.http.put<Seller>(`http://localhost:8080/sellers/${seller.id}`, seller);
  }

  delete(seller: Seller) {
    return this.http.delete<void>(`http://localhost:8080/sellers/${seller.id}`);
  }

}

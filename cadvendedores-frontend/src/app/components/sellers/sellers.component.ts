import { Component } from '@angular/core';
import { Seller } from '../../interfaces/Seller';
import { SafeCall } from '@angular/compiler';

@Component({
  selector: 'app-sellers',
  templateUrl: './sellers.component.html',
  styleUrl: './sellers.component.css'
})
export class SellersComponent {
  title = 'Vendedores Cadastrados';

  seller: Seller = {} as Seller;

  genders: string[] = [
    "Masculino",
    "Feminino",
    "Não Informado"
  ];

  sellers : Seller[] = [
    {id:1, name:"João", salary:1500.50, bonus:0.10, gender:1},
    {id:2, name:"Maria", salary:1800.50, bonus:0.2055, gender:2},
    {id:3, name:"Darcy", salary:2000.50, bonus:0.255, gender:3}
  ];

  saveBook() {
    this.seller.id = this.sellers.length+1;
    this.seller.bonus /= 100; 
    this.sellers.push(this.seller);
    this.seller = {} as Seller;
  }



}

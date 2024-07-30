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
  isUpdate: Boolean = false;
  idCount: number = 3;

  genders: string[] = [
    "Masculino",
    "Feminino",
    "Não Informado"
  ];

  sellers : Seller[] = [
    {id:1, name:"João", salary:1500.50, bonus:10, gender:1},
    {id:2, name:"Maria", salary:1800.50, bonus:20.55, gender:2},
    {id:3, name:"Darcy", salary:2000.50, bonus:25.5, gender:3}
  ];

  saveSeller() {
    if (!this.isUpdate) {
      this.seller.id = this.idCount+1;
      this.sellers.push(this.seller);
      this.idCount++;
    } 
    this.seller = {} as Seller;
    this.isUpdate = false;

  };

  updateSeller(selectedSeller: Seller) {
    this.isUpdate = true;
    this.seller = selectedSeller;
  };

  removeSeller(selectedSeller: Seller) {
    this.sellers = this.sellers.filter(s => s.id !== selectedSeller.id);
  };



}

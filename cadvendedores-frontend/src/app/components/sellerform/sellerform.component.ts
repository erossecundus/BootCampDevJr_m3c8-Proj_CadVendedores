import { Component } from '@angular/core';
import { Seller } from '../../interfaces/Seller';

@Component({
  selector: 'app-sellerform',
  templateUrl: './sellerform.component.html',
  styleUrl: './sellerform.component.css'
})
export class SellerformComponent {
  title = 'Cadastro de Vendedor';

  seller: Seller = {} as Seller;
}

import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Seller } from '../../interfaces/Seller';

@Component({
  selector: 'app-sellerform',
  templateUrl: './sellerform.component.html',
  styleUrl: './sellerform.component.css'
})
export class SellerformComponent {
  title = 'Cadastro de Vendedor';

  @Input()
  seller?: Seller;

  @Input()
  genders: string[] = [];

  @Output()
  saveEmitter = new EventEmitter;

  save() {
    this.saveEmitter.emit(true)
  }

  cancel() {
    this.saveEmitter.emit(false)
  }

}

import { Component } from '@angular/core';
import { Seller } from '../../interfaces/Seller';
import { SafeCall } from '@angular/compiler';
import { SellersService } from '../../services/sellers.service';

@Component({
  selector: 'app-sellers',
  templateUrl: './sellers.component.html',
  styleUrl: './sellers.component.css'
})
export class SellersComponent {
  title = 'Vendedores Cadastrados';

  showForm: boolean = false;
  isEdit: boolean = false;

  seller: Seller = {} as Seller;

  genders: string[] = [];
  sellers: Seller[] = [];

  constructor(private sellerService: SellersService) { }

  ngOnInit(): void {
    this.loadGenders();
    this.loadSellers();
  }

  loadGenders() {
    this.genders = this.sellerService.getGenders();
  }
  loadSellers() {
    this.sellerService.getSellers().subscribe({
      next: data => { this.sellers = data }
    });
  }

  saveSeller(save: Boolean) {

    if(save) {
      if(this.isEdit) {
        this.sellerService.update(this.seller);
        this.isEdit = false;
      }
      else {        
        this.sellerService.save(this.seller).subscribe({
          next: data => {
            this.sellers.push(data);
          }
        });
      }
    }
    this.seller = {} as Seller;
    this.showForm = false;
  }

  editSeller(selectedSeller: Seller) {
    this.seller = selectedSeller;
    this.showForm = true;
    this.isEdit = true;
  }

  removeSeller(selectedSeller: Seller) {
    this.sellerService.delete(selectedSeller).subscribe({
      next: () => this.sellers = this.sellers.filter(s => s.id !== selectedSeller.id)
    }); 
  }

  create() {
    this.showForm = true;
  }


}

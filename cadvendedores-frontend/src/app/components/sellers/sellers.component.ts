import { Component, input } from '@angular/core';
import { Seller } from '../../interfaces/Seller';
import { SellersService } from '../../services/sellers.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

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
  deleteSeller: Seller = {} as Seller;

  genders: string[] = [];

  sellers: Seller[] = [];


  constructor(private sellerService: SellersService,
    private modalService: NgbModal) { }

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
    if (save) {
      if (this.isEdit) {
        this.sellerService.update(this.seller).subscribe();
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

  removeSeller(modal: any, selectedSeller: Seller) {
    this.deleteSeller = selectedSeller;
    this.modalService.open(modal).result.then(
      (confirm) => {
        if (confirm) {
          this.sellerService.delete(selectedSeller).subscribe({
            next: () => this.sellers = this.sellers.filter(s => s.id !== selectedSeller.id)
          }); 
        }
      }
    );

  }

  create() {
    this.showForm = true;
  }
}

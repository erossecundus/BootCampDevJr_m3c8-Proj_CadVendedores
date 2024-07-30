import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SellerformComponent } from './sellerform.component';

describe('SellerformComponent', () => {
  let component: SellerformComponent;
  let fixture: ComponentFixture<SellerformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SellerformComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SellerformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

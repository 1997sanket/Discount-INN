import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StaffCheckoutComponent } from './staff-checkout.component';

describe('StaffCheckoutComponent', () => {
  let component: StaffCheckoutComponent;
  let fixture: ComponentFixture<StaffCheckoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StaffCheckoutComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StaffCheckoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StaffBookingComponent } from './staff-booking.component';

describe('StaffBookingComponent', () => {
  let component: StaffBookingComponent;
  let fixture: ComponentFixture<StaffBookingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StaffBookingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StaffBookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

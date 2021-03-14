import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelSelectionComponent } from './hotel-selection.component';

describe('HotelSelectionComponent', () => {
  let component: HotelSelectionComponent;
  let fixture: ComponentFixture<HotelSelectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelSelectionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HotelSelectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

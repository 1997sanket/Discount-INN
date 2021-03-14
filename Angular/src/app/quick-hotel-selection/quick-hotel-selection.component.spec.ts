import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuickHotelSelectionComponent } from './quick-hotel-selection.component';

describe('QuickHotelSelectionComponent', () => {
  let component: QuickHotelSelectionComponent;
  let fixture: ComponentFixture<QuickHotelSelectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuickHotelSelectionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(QuickHotelSelectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

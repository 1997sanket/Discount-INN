import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindTheHotelComponent } from './find-the-hotel.component';

describe('FindTheHotelComponent', () => {
  let component: FindTheHotelComponent;
  let fixture: ComponentFixture<FindTheHotelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FindTheHotelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FindTheHotelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

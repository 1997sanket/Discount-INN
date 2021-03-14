import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StaffCheckinComponent } from './staff-checkin.component';

describe('StaffCheckinComponent', () => {
  let component: StaffCheckinComponent;
  let fixture: ComponentFixture<StaffCheckinComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StaffCheckinComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StaffCheckinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

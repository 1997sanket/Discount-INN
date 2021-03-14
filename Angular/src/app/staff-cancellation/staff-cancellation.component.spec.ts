import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StaffCancellationComponent } from './staff-cancellation.component';

describe('StaffCancellationComponent', () => {
  let component: StaffCancellationComponent;
  let fixture: ComponentFixture<StaffCancellationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StaffCancellationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StaffCancellationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

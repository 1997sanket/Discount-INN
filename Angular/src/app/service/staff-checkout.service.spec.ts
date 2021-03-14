import { TestBed } from '@angular/core/testing';

import { StaffCheckoutService } from './staff-checkout.service';

describe('StaffCheckoutService', () => {
  let service: StaffCheckoutService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StaffCheckoutService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { StaffLoginGuard } from './staff-login.guard';

describe('StaffLoginGuard', () => {
  let guard: StaffLoginGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(StaffLoginGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});

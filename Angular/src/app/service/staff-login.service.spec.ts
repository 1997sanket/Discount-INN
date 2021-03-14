import { TestBed } from '@angular/core/testing';

import { StaffLoginService } from './staff-login.service';

describe('StaffLoginService', () => {
  let service: StaffLoginService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StaffLoginService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

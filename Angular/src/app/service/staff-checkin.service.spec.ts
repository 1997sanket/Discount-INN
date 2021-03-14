import { TestBed } from '@angular/core/testing';

import { StaffCheckinService } from './staff-checkin.service';

describe('StaffCheckinService', () => {
  let service: StaffCheckinService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StaffCheckinService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

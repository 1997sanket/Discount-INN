import { TestBed } from '@angular/core/testing';

import { FindTheHotelService } from './find-the-hotel.service';

describe('FindTheHotelService', () => {
  let service: FindTheHotelService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FindTheHotelService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

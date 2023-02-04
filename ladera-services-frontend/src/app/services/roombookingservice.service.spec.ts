import { TestBed } from '@angular/core/testing';

import { RoombookingserviceService } from './roombookingservice.service';

describe('RoombookingserviceService', () => {
  let service: RoombookingserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RoombookingserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

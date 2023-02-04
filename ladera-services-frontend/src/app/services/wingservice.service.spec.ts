import { TestBed } from '@angular/core/testing';

import { WingserviceService } from './wingservice.service';

describe('WingserviceService', () => {
  let service: WingserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WingserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

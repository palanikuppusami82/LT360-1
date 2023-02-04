import { TestBed } from '@angular/core/testing';

import { CurrentuserserviceService } from './currentuserservice.service';

describe('CurrentuserserviceService', () => {
  let service: CurrentuserserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CurrentuserserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

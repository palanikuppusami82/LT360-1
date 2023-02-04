import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WingallotmentComponent } from './wingallotment.component';

describe('WingallotmentComponent', () => {
  let component: WingallotmentComponent;
  let fixture: ComponentFixture<WingallotmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WingallotmentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WingallotmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

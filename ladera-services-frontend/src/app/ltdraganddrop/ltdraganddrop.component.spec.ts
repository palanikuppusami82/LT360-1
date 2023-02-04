import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LtdraganddropComponent } from './ltdraganddrop.component';

describe('LtdraganddropComponent', () => {
  let component: LtdraganddropComponent;
  let fixture: ComponentFixture<LtdraganddropComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LtdraganddropComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LtdraganddropComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

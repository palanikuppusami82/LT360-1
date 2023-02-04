import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuccessfulpageComponent } from './successfulpage.component';

describe('SuccessfulpageComponent', () => {
  let component: SuccessfulpageComponent;
  let fixture: ComponentFixture<SuccessfulpageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SuccessfulpageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SuccessfulpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

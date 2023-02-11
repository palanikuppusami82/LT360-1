import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatewingComponent } from './createwing.component';

describe('CreatewingComponent', () => {
  let component: CreatewingComponent;
  let fixture: ComponentFixture<CreatewingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatewingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreatewingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

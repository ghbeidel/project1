import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EOptionsComponent } from './e-options.component';

describe('EOptionsComponent', () => {
  let component: EOptionsComponent;
  let fixture: ComponentFixture<EOptionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EOptionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EOptionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

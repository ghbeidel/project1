import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EViewComponent } from './e-view.component';

describe('EViewComponent', () => {
  let component: EViewComponent;
  let fixture: ComponentFixture<EViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

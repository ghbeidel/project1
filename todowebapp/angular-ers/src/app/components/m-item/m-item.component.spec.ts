import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MItemComponent } from './m-item.component';

describe('MItemComponent', () => {
  let component: MItemComponent;
  let fixture: ComponentFixture<MItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

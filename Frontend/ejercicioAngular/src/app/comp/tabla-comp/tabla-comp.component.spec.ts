import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TablaCompComponent } from './tabla-comp.component';

describe('TablaCompComponent', () => {
  let component: TablaCompComponent;
  let fixture: ComponentFixture<TablaCompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TablaCompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TablaCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

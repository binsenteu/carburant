import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RechercheCodePostalComponent } from './recherche-code-postal.component';

describe('RechercheCodePostalComponent', () => {
  let component: RechercheCodePostalComponent;
  let fixture: ComponentFixture<RechercheCodePostalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RechercheCodePostalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RechercheCodePostalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

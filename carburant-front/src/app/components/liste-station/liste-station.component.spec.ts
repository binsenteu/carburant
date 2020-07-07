import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeStationComponent } from './liste-station.component';

describe('ListeStationComponent', () => {
  let component: ListeStationComponent;
  let fixture: ComponentFixture<ListeStationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListeStationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeStationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

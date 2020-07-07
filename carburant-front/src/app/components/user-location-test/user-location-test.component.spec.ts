import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserLocationTestComponent } from './user-location-test.component';

describe('UserLocationTestComponent', () => {
  let component: UserLocationTestComponent;
  let fixture: ComponentFixture<UserLocationTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserLocationTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserLocationTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

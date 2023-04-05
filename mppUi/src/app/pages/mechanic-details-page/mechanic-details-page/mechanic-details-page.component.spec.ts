import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MechanicDetailsPageComponent } from './mechanic-details-page.component';

describe('MechanicDetailsPageComponent', () => {
  let component: MechanicDetailsPageComponent;
  let fixture: ComponentFixture<MechanicDetailsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MechanicDetailsPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MechanicDetailsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

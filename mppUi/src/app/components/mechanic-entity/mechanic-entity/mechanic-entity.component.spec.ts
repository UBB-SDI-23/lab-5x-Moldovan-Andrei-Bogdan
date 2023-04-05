import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MechanicEntityComponent } from './mechanic-entity.component';

describe('MechanicEntityComponent', () => {
  let component: MechanicEntityComponent;
  let fixture: ComponentFixture<MechanicEntityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MechanicEntityComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MechanicEntityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

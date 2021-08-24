import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TratamientoRegistrarComponent } from './tratamientoRegistrar.component';

describe('TratamientoComponent', () => {
  let component: TratamientoRegistrarComponent;
  let fixture: ComponentFixture<TratamientoRegistrarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TratamientoRegistrarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TratamientoRegistrarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

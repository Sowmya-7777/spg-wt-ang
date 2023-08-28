import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomisedproductComponent } from './customisedproduct.component';

describe('CustomisedproductComponent', () => {
  let component: CustomisedproductComponent;
  let fixture: ComponentFixture<CustomisedproductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomisedproductComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomisedproductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

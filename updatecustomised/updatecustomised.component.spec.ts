import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatecustomisedComponent } from './updatecustomised.component';

describe('UpdatecustomisedComponent', () => {
  let component: UpdatecustomisedComponent;
  let fixture: ComponentFixture<UpdatecustomisedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdatecustomisedComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdatecustomisedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

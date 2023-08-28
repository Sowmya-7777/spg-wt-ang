import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StafftableComponent } from './stafftable.component';

describe('StafftableComponent', () => {
  let component: StafftableComponent;
  let fixture: ComponentFixture<StafftableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StafftableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StafftableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

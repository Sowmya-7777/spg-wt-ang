import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReviewtableComponent } from './reviewtable.component';

describe('ReviewtableComponent', () => {
  let component: ReviewtableComponent;
  let fixture: ComponentFixture<ReviewtableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReviewtableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReviewtableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

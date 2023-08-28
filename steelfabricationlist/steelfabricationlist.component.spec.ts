import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SteelfabricationlistComponent } from './steelfabricationlist.component';

describe('SteelfabricationlistComponent', () => {
  let component: SteelfabricationlistComponent;
  let fixture: ComponentFixture<SteelfabricationlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SteelfabricationlistComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SteelfabricationlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

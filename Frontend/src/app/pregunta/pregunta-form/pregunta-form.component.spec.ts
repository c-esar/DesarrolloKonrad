import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreguntaFormComponent } from './pregunta-form.component';

describe('PreguntaFormComponent', () => {
  let component: PreguntaFormComponent;
  let fixture: ComponentFixture<PreguntaFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PreguntaFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PreguntaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioGuardadoFormComponent } from './formulario-guardado-form.component';

describe('FormularioGuardadoFormComponent', () => {
  let component: FormularioGuardadoFormComponent;
  let fixture: ComponentFixture<FormularioGuardadoFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormularioGuardadoFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormularioGuardadoFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

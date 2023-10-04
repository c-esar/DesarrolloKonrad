import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioUsuarioFormComponent } from './formulario-usuario-form.component';

describe('FormularioUsuarioFormComponent', () => {
  let component: FormularioUsuarioFormComponent;
  let fixture: ComponentFixture<FormularioUsuarioFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormularioUsuarioFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormularioUsuarioFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { TablaService } from 'src/app/services/tabla.service';
import { Persona } from 'src/app/model/persona';
import { Router } from '@angular/router';


@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.scss']
})


export class FormularioComponent implements OnInit {
  public formGroupVar: FormGroup;


  constructor(private fb: FormBuilder, private tablaServicio: TablaService,
    private router: Router) {
    this.formGroupVar = this.fb.group({
      nombre: ["", [Validators.required]],
      apellido1: ["", [Validators.required]],
      apellido2: ["", [Validators.required]],
      edad: [0, [Validators.required]]
    });
  }

  ngOnInit(): void {
    if (this.tablaServicio.selectedPerson != null) {
      this.formGroupVar.setValue({
        nombre: this.tablaServicio.selectedPerson.nombre,
        apellido1: this.tablaServicio.selectedPerson.apellido1,
        apellido2: this.tablaServicio.selectedPerson.apellido2,
        edad: this.tablaServicio.selectedPerson.edad
      })
    }
  }

  submit() {
    if (this.formGroupVar.valid) {
      var persona = new Persona();
      persona = this.formGroupVar.value;
      if (this.tablaServicio.selectedPerson == null) {
        this.tablaServicio.push(persona);
      } else {
        this.tablaServicio.modify(persona);
      }
      this.tablaServicio.selectedPerson = null;
      this.router.navigate([""]);
    }
  }

  cancel() {
    this.tablaServicio.selectedPerson = null;
    this.router.navigate([""]);
  }


}

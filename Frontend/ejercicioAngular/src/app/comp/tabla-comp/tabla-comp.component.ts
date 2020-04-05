import { Component, OnInit, ɵɵcontainerRefreshEnd } from '@angular/core';
import { TablaService } from 'src/app/services/tabla.service';
import { Persona } from 'src/app/model/persona';

import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tabla-comp',
  templateUrl: './tabla-comp.component.html',
  styleUrls: ['./tabla-comp.component.scss']
})
export class TablaCompComponent implements OnInit {

  displayedColumns: string[] = ['nombre', 'apellido1', 'apellido2', 'edad', "Menu"];
  dataSource = new MatTableDataSource();

  constructor(private tablaService: TablaService, private router: Router) {
    this.tablaService.getSubject().subscribe(data => {
      this.dataSource.data = data;
    })
  }

  ngOnInit(): void {
  }

  addRow() {
    this.router.navigate(["formulario"]);
  }

  clickBorrar(persona: Persona) {
    this.tablaService.delete(persona);
  }
  clickEditar(persona: Persona) {
    this.tablaService.selectedPerson = persona;
    this.router.navigate(["formulario"]);
  }
  deleteAll() {
    this.tablaService.deleteAll();
  }

  clickUndo(){
    this.tablaService.undo();

  }
  clickUndoAll(){

  }


}

import { Injectable } from '@angular/core';
import { Persona } from '../model/persona';
import { Subject, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TablaService {
  private ListaPersonas: Persona[] = [
    { nombre: "Raul", apellido1: "Boix", apellido2: "Palomares", edad: 29 },
    { nombre: "Raul", apellido1: "Boix", apellido2: "Palomares", edad: 11 },
    { nombre: "Raul", apellido1: "Boix", apellido2: "Palomares", edad: 5 },
    { nombre: "Raul", apellido1: "Boix", apellido2: "Palomares", edad: 51 },
    { nombre: "Raul", apellido1: "Boix", apellido2: "Palomares", edad: 45 },
    { nombre: "Raul", apellido1: "Boix", apellido2: "Palomares", edad: 34 },
    { nombre: "Raul", apellido1: "Boix", apellido2: "Palomares", edad: 42 },
    { nombre: "Raul", apellido1: "Boix", apellido2: "Palomares", edad: 41 },
    { nombre: "Raul", apellido1: "Boix", apellido2: "Palomares", edad: 15 },
    { nombre: "Raul", apellido1: "Boix", apellido2: "Palomares", edad: 16 },
    { nombre: "Raul", apellido1: "Boix", apellido2: "Palomares", edad: 25 },
    { nombre: "Raul", apellido1: "Boix", apellido2: "Palomares", edad: 60 },
    { nombre: "Raul", apellido1: "Boix", apellido2: "Palomares", edad: 6 },
    { nombre: "Raul", apellido1: "Boix", apellido2: "Palomares", edad: 12 },
    { nombre: "Raul", apellido1: "Boix", apellido2: "Palomares", edad: 58 },
    { nombre: "Raul", apellido1: "Boix", apellido2: "Palomares", edad: 32 }];
  private subject: BehaviorSubject<Persona[]> = new BehaviorSubject(this.ListaPersonas);
  private personasEliminadas: Persona[] = [];
  public selectedPerson: Persona;
  constructor() { }

  public getSubject() {
    return this.subject;
  }

  push(persona: Persona): void {
    this.ListaPersonas.push(persona);
    this.subject.next(this.ListaPersonas);
  }

  delete(personaBorrar: Persona): void {
    this.ListaPersonas = <Persona[]>this.ListaPersonas.filter(persona => {
      return persona != personaBorrar
    })
    this.personasEliminadas.push(personaBorrar);
    console.log(this.personasEliminadas);
    this.subject.next(this.ListaPersonas);
  }

  modify(personaModify: Persona): void {

    this.ListaPersonas.forEach((persona, index) => {
      if (persona == this.selectedPerson) {
        this.ListaPersonas[index] = personaModify;
      }
    })
    this.subject.next(this.ListaPersonas);
  }

  deleteAll() {
    this.personasEliminadas = this.personasEliminadas.concat(this.ListaPersonas);
    this.ListaPersonas = [];
    this.subject.next(this.ListaPersonas);
  }
  undo(){
    if(this.personasEliminadas.length > 0){
      this.ListaPersonas.push(this.personasEliminadas.pop());
      this.subject.next(this.ListaPersonas);
    }
    
  }

  undoAll(){
    if(this.personasEliminadas.length > 0){
      this.ListaPersonas = this.ListaPersonas.concat(this.personasEliminadas);
      this.subject.next(this.ListaPersonas);
    }
    
  }


}


export interface PersonaInterface{
    nombre:string;
    apellido1:string;
    apellido2:string;
}
export class Persona implements PersonaInterface{
    nombre:string;
    apellido1:string;
    apellido2:string;
    constructor(){};
}
export class tableController{
    private personas:[Persona] = [{nombre:"raul",apellido1:"boix",apellido2:"palomares"}];
    private deleteButton = "<button class='borrar' type='button' onclick='deleteRow(this)'>Borrar</button>"
    private modifyButton = "<button class='modificar' type='button' onclick='getRow(this)'>Modificar</button>";
    private selectedRow:number = -1;
    constructor(){
    }
    public addRow(tableID:string,persona:Persona) {
        this.personas.push(persona);
        this.fillTable(tableID);
      }
    
      fillTable(tableID:string){
        var tableRef = document.getElementById(tableID);
        tableRef.innerHTML = "";

        this.personas.forEach(persona => {
            
            var newRow   = (<HTMLTableElement>tableRef).insertRow();
            newRow.insertCell(0).appendChild(document.createTextNode(persona.nombre));
            newRow.insertCell(1).appendChild(document.createTextNode(persona.apellido1));
            newRow.insertCell(2).appendChild(document.createTextNode(persona.apellido2));
            newRow.insertCell(3).innerHTML = this.deleteButton;
            newRow.insertCell(4).innerHTML = this.modifyButton;
            
        });
      }
      deleteRow(boton:any){
        var tableRef = document.getElementById("tabla");
        (<HTMLTableElement>tableRef).deleteRow(boton.parentNode.parentNode.rowIndex-1);
      }

      getRow(boton:any){
          
        var tableRef = document.getElementById("tabla");
        this.selectedRow = boton.parentNode.parentNode.rowIndex-1;
        var row = (<HTMLTableElement>tableRef).rows[this.selectedRow];
        var persona:Persona = new Persona();
        persona.nombre = row.cells[0].innerHTML;
        persona.apellido1 = row.cells[1].innerHTML;
        persona.apellido2 = row.cells[2].innerHTML;
        

        return persona;
      }

      modifyRow(tableID:string,personaModificada:Persona){
        console.log(this.personas);
          this.personas.forEach((persona,index)=>{
              if(index == this.selectedRow){
                  this.personas[index] = personaModificada;
              }
          })
          console.log(this.personas);
          

      }
      deleteAll(tableID:string){
          this.personas = [null];
          var tableRef = document.getElementById(tableID);
        tableRef.innerHTML = "";
      }
      

}

(<HTMLButtonElement>document.getElementById("botonSubmit")).disabled = true;
(<HTMLButtonElement>document.getElementById("cancelarForm")).disabled = true;
  let tablaController = new tableController(); 
  tablaController.fillTable("tabla");
    var isNewRow:boolean = true;
    
  function deleteRow(boton:any){
    tablaController.deleteRow(boton);
  }

  function getRow(boton:any){
    (<HTMLButtonElement>document.getElementById("borrarTodo")).disabled = true;
    
    (<HTMLButtonElement>document.getElementById("botonSubmit")).disabled = false;
    (<HTMLButtonElement>document.getElementById("cancelarForm")).disabled = false;
      var persona:Persona = tablaController.getRow(boton);
      isNewRow = false;
      fillForm(persona);
      disableFormFields(false);
  }
  function disableFormFields(estado:boolean){
    (<HTMLInputElement>document.getElementById("nombre")).disabled = estado;
    (<HTMLInputElement>document.getElementById("apellido1")).disabled = estado;
    (<HTMLInputElement>document.getElementById("apellido2")).disabled = estado;
  }

  function fillForm(persona:Persona){
    (<HTMLInputElement>document.getElementById("nombre")).value = persona.nombre;
    (<HTMLInputElement>document.getElementById("apellido1")).value = persona.apellido1;
    (<HTMLInputElement>document.getElementById("apellido2")).value = persona.apellido2;
  }

  function clearForm(){
    (<HTMLInputElement>document.getElementById("nombre")).value = "";
    (<HTMLInputElement>document.getElementById("apellido1")).value = "";
    (<HTMLInputElement>document.getElementById("apellido2")).value = "";
  }
  
  disableFormFields(true);

  document.getElementById("botonSubmit").addEventListener("click",()=>{
    var persona:Persona = new Persona();
    
    persona.nombre = (<HTMLInputElement>document.getElementById("nombre")).value;
    persona.apellido1 = (<HTMLInputElement>document.getElementById("apellido1")).value;
    persona.apellido2 = (<HTMLInputElement>document.getElementById("apellido2")).value;
    if(isNewRow){
        tablaController.addRow("tabla",persona);
    } else{
        tablaController.modifyRow("tabla",persona);
        tablaController.fillTable("tabla");
        clearForm();
        isNewRow = true;
        
    }
    disableFormFields(true);
    
    (<HTMLButtonElement>document.getElementById("borrarTodo")).disabled = false;
    (<HTMLButtonElement>document.getElementById("botonSubmit")).disabled = true;
    (<HTMLButtonElement>document.getElementById("cancelarForm")).disabled = true;

    event.preventDefault();
  })



  document.getElementById("nuevaFila").addEventListener("click",()=>{
    disableFormFields(false);
    isNewRow = true;
    (<HTMLButtonElement>document.getElementById("borrarTodo")).disabled = true;
    
    (<HTMLButtonElement>document.getElementById("botonSubmit")).disabled = false;
    (<HTMLButtonElement>document.getElementById("cancelarForm")).disabled = false;
    
    event.preventDefault();
  })

  document.getElementById("borrarTodo").addEventListener("click",()=>{
    isNewRow = true;
    tablaController.deleteAll("tabla");
    

    event.preventDefault();
  })

  document.getElementById("cancelarForm").addEventListener("click",()=>{
    clearForm();
    (<HTMLButtonElement>document.getElementById("borrarTodo")).disabled = false;
    
    (<HTMLButtonElement>document.getElementById("botonSubmit")).disabled = true;
    (<HTMLButtonElement>document.getElementById("cancelarForm")).disabled = true;
    
    event.preventDefault();
  })

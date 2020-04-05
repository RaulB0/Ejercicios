"use strict";
exports.__esModule = true;
var Persona = /** @class */ (function () {
    function Persona() {
    }
    ;
    return Persona;
}());
exports.Persona = Persona;
var tableController = /** @class */ (function () {
    function tableController() {
        this.personas = [{ nombre: "raul", apellido1: "boix", apellido2: "palomares" }];
        this.deleteButton = "<button class='borrar' type='button' onclick='deleteRow(this)'>Borrar</button>";
        this.modifyButton = "<button class='modificar' type='button' onclick='getRow(this)'>Modificar</button>";
        this.selectedRow = -1;
    }
    tableController.prototype.addRow = function (tableID, persona) {
        this.personas.push(persona);
        this.fillTable(tableID);
    };
    tableController.prototype.fillTable = function (tableID) {
        var _this = this;
        var tableRef = document.getElementById(tableID);
        tableRef.innerHTML = "";
        this.personas.forEach(function (persona) {
            var newRow = tableRef.insertRow();
            newRow.insertCell(0).appendChild(document.createTextNode(persona.nombre));
            newRow.insertCell(1).appendChild(document.createTextNode(persona.apellido1));
            newRow.insertCell(2).appendChild(document.createTextNode(persona.apellido2));
            newRow.insertCell(3).innerHTML = _this.deleteButton;
            newRow.insertCell(4).innerHTML = _this.modifyButton;
        });
    };
    tableController.prototype.deleteRow = function (boton) {
        var tableRef = document.getElementById("tabla");
        tableRef.deleteRow(boton.parentNode.parentNode.rowIndex - 1);
    };
    tableController.prototype.getRow = function (boton) {
        var tableRef = document.getElementById("tabla");
        this.selectedRow = boton.parentNode.parentNode.rowIndex - 1;
        var row = tableRef.rows[this.selectedRow];
        var persona = new Persona();
        persona.nombre = row.cells[0].innerHTML;
        persona.apellido1 = row.cells[1].innerHTML;
        persona.apellido2 = row.cells[2].innerHTML;
        return persona;
    };
    tableController.prototype.modifyRow = function (tableID, personaModificada) {
        var _this = this;
        console.log(this.personas);
        this.personas.forEach(function (persona, index) {
            if (index == _this.selectedRow) {
                _this.personas[index] = personaModificada;
            }
        });
        console.log(this.personas);
    };
    tableController.prototype.deleteAll = function (tableID) {
        this.personas = [null];
        var tableRef = document.getElementById(tableID);
        tableRef.innerHTML = "";
    };
    return tableController;
}());
exports.tableController = tableController;
document.getElementById("botonSubmit").disabled = true;
document.getElementById("cancelarForm").disabled = true;
var tablaController = new tableController();
tablaController.fillTable("tabla");
var isNewRow = true;
function deleteRow(boton) {
    tablaController.deleteRow(boton);
}
function getRow(boton) {
    document.getElementById("borrarTodo").disabled = true;
    document.getElementById("botonSubmit").disabled = false;
    document.getElementById("cancelarForm").disabled = false;
    var persona = tablaController.getRow(boton);
    isNewRow = false;
    fillForm(persona);
    disableFormFields(false);
}
function disableFormFields(estado) {
    document.getElementById("nombre").disabled = estado;
    document.getElementById("apellido1").disabled = estado;
    document.getElementById("apellido2").disabled = estado;
}
function fillForm(persona) {
    document.getElementById("nombre").value = persona.nombre;
    document.getElementById("apellido1").value = persona.apellido1;
    document.getElementById("apellido2").value = persona.apellido2;
}
function clearForm() {
    document.getElementById("nombre").value = "";
    document.getElementById("apellido1").value = "";
    document.getElementById("apellido2").value = "";
}
disableFormFields(true);
document.getElementById("botonSubmit").addEventListener("click", function () {
    var persona = new Persona();
    persona.nombre = document.getElementById("nombre").value;
    persona.apellido1 = document.getElementById("apellido1").value;
    persona.apellido2 = document.getElementById("apellido2").value;
    if (isNewRow) {
        tablaController.addRow("tabla", persona);
    }
    else {
        tablaController.modifyRow("tabla", persona);
        tablaController.fillTable("tabla");
        clearForm();
        isNewRow = true;
    }
    disableFormFields(true);
    document.getElementById("borrarTodo").disabled = false;
    document.getElementById("botonSubmit").disabled = true;
    document.getElementById("cancelarForm").disabled = true;
    event.preventDefault();
});
document.getElementById("nuevaFila").addEventListener("click", function () {
    disableFormFields(false);
    isNewRow = true;
    document.getElementById("borrarTodo").disabled = true;
    document.getElementById("botonSubmit").disabled = false;
    document.getElementById("cancelarForm").disabled = false;
    event.preventDefault();
});
document.getElementById("borrarTodo").addEventListener("click", function () {
    isNewRow = true;
    tablaController.deleteAll("tabla");
    event.preventDefault();
});
document.getElementById("cancelarForm").addEventListener("click", function () {
    clearForm();
    document.getElementById("borrarTodo").disabled = false;
    document.getElementById("botonSubmit").disabled = true;
    document.getElementById("cancelarForm").disabled = true;
    event.preventDefault();
});

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TablaCompComponent } from './comp/tabla-comp/tabla-comp.component';
import { FormularioComponent } from './comp/formulario/formulario.component';


const routes: Routes = [
  {
    path: "",
    component: TablaCompComponent
  },
  {
    path: "formulario",
    component: FormularioComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

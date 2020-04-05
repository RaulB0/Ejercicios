import { Component, OnInit } from '@angular/core';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label } from 'ng2-charts';
import { TablaService } from 'src/app/services/tabla.service';

@Component({
  selector: 'app-bar-chart',
  templateUrl: './bar-chart.component.html',
  styleUrls: ['./bar-chart.component.scss']
})
export class BarChartComponent implements OnInit {

  barChartOptions: ChartOptions = {
    responsive: true,
    scales: {
      yAxes: [{
        ticks: {
          beginAtZero: true
        }
      }]
    }
  };
  barChartLabels: Label[] = ['1-10', '11-20', '21-30', '31-40', '41-50', '51+'];
  barChartType: ChartType = 'bar';
  barChartLegend = true;
  barChartPlugins = [];
  diez: number = 0;
  veinte: number = 0;
  treinta: number = 0;
  cuarenta: number = 0;
  cinquenta: number = 0;
  mayor: number = 0;

  barChartData: ChartDataSets[] = [
    { data: [this.diez, this.veinte, this.treinta, this.cuarenta, this.cinquenta, this.mayor], label: 'Edades' }
  ];

  constructor(private tablaService: TablaService) {
    this.tablaService.getSubject().subscribe(data => {
      this.resetValues();
      data.forEach(persona => {

        if (persona.edad >= 51) {
          this.mayor++;
          return;
        }
        if (persona.edad >= 41) {
          this.cinquenta++;
          return;
        }
        if (persona.edad >= 31) {
          this.cuarenta++;
          return;
        }
        if (persona.edad >= 21) {
          this.treinta++;
          return;
        }
        if (persona.edad >= 11) {
          this.veinte++;
          return;
        }
        if (persona.edad >= 1) {
          this.diez++;
          return;
        }
      })
      this.barChartData = [
        { data: [this.diez, this.veinte, this.treinta, this.cuarenta, this.cinquenta, this.mayor], label: 'Edades' }
      ];
    })
  }

  ngOnInit(): void {
  }
  resetValues() {
    this.diez = 0;
    this.veinte = 0;
    this.treinta = 0;
    this.cuarenta = 0;
    this.cinquenta = 0;
    this.mayor = 0;
  }

}

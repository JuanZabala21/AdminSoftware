import { Component, OnInit } from '@angular/core';
import Chart from 'chart.js';
import {ActivatedRoute, Router} from '@angular/router';
import {GlobalServices} from '../../shared/services/global.services';
import {environment} from '../../../environments/environment';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';

declare let alertify: any;

@Component({
    selector: 'dashboard-cmp',
    moduleId: module.id,
    templateUrl: 'dashboard.component.html',
    styleUrls: ['dashboard.component.scss']
})


export class DashboardComponent implements OnInit{
  filters: FormGroup;
  registerCount;
  empleadosCount;
  tratamientosCount;
  productosCount;

  year = (new Date()).getFullYear();


  public canvas : any;
  public ctx;
  public chartColor;
  public chartEmail;
  public chartHours;
  public lineChart;
  public lineChart2;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private globalServices: GlobalServices,
    private fb: FormBuilder) {
      this.filters = fb.group({
        gunValue: new FormControl()
      });
    }


    ngOnInit(){

        const data = {
        };
        this.globalServices.httpServicesResponse(data, environment.Url + 'global/dashboard').subscribe( res => {
          this.registerCount= res.dashboard.registerCount;
          this.empleadosCount= res.dashboard.empleadosCount;
          this.tratamientosCount= res.dashboard.tratamientosCount;
          this.productosCount= res.dashboard.productosCount;

          this.chartEmail.data.datasets[0].data=[res.dashboard.registerCount,res.dashboard.empleadosCount,res.dashboard.tratamientosCount,res.dashboard.productosCount];
          this.chartEmail.update();

          this.lineChart.config.data.datasets[0].data= res.dashboard.registerPerMonth;
          this.lineChart.update();

          this.lineChart2.config.data.datasets[0].data= res.dashboard.registerPerMonthInstagram;
          this.lineChart2.config.data.datasets[1].data= res.dashboard.registerPerMonthAmigos;
          this.lineChart2.config.data.datasets[2].data= res.dashboard.registerPerMonthOtros;
          this.lineChart2.update();

          }
        )

    //GRAFICO DE REGISTROS
      this.canvas = document.getElementById("chartEmail");
      this.ctx = this.canvas.getContext("2d");
      this.chartEmail = new Chart(this.ctx, {
        type: 'pie',
        data: {
          labels: ['Pacientes', 'Empleados', 'Tratamientos', 'Productos'],
          datasets: [{
            label: "",
            pointRadius: 0,
            pointHoverRadius: 0,
            backgroundColor: [
              '#6bd098',
              '#ef8157',
              '#fcc468',
              '#4acccd'
            ],
            borderWidth: 0,

            data: []
          }]
        },
        options: {
          legend:{
            display:false
          }
        }
      });

      //GRAFICO DE REGISTROS POR MES

      var speedCanvas = document.getElementById("speedChart");

      var dataSecond = {
        data: [],
        fill: false,
        borderColor: '#6bd098',
        backgroundColor: 'transpartent',
        pointBorderColor: '#6bd098',
        pointRadius: 4,
        pointHoverRadius: 4,
        pointBorderWidth: 8
      };

      var speedData = {
        labels: ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dec"],
        datasets: [ dataSecond]
      };

      var chartOptions = {
        legend: {
          display: false,
          position: 'top'
        }
      };

      this.lineChart = new Chart(speedCanvas, {
        type: 'line',
        hover: true,
        data: speedData,
        options: chartOptions
      });


      //GRAFICO DE REFERENCIAS

      var speedCanvas = document.getElementById("speedChart2");

      var dataFirst = {
        data: [],
        fill: false,
        borderColor: '#fcc468',
        backgroundColor: 'transparent',
        pointBorderColor: '#fcc468',
        pointRadius: 4,
        pointHoverRadius: 4,
        pointBorderWidth: 8,
      };

      var dataSecond = {
        data: [],
        fill: false,
        borderColor: '#6bd098',
        backgroundColor: 'transpartent',
        pointBorderColor: '#6bd098',
        pointRadius: 4,
        pointHoverRadius: 4,
        pointBorderWidth: 8
      };

      var dataThird = {
        data: [],
        fill: false,
        borderColor: '#ef8157',
        backgroundColor: 'transpartent',
        pointBorderColor: '#ef8157',
        pointRadius: 4,
        pointHoverRadius: 4,
        pointBorderWidth: 8
      };

      var speedData = {
        labels: ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dec"],
        datasets: [ dataSecond,  dataFirst, dataThird]
      };

      var chartOptions = {
        legend: {
          display: false,
          position: 'top'
        }
      };

      this.lineChart2 = new Chart(speedCanvas, {
        type: 'line',
        hover: true,
        data: speedData,
        options: chartOptions
      });
    }

    updateGun() {
      const data = {
        ...this.filters.value
      };
      this.globalServices.httpServicesResponse(data,
        environment.Url + '/global/updateGun').subscribe( response => {
          if (response.type === 'error') {
            alertify.success('Ha ocurrido un error al actualizar');
          } else {
            this.filters.reset();
            alertify.success('Disparos de pistola han sido actualizados');
          }
        },
        console.error);
    }




}


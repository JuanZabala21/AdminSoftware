import { Component, OnInit } from '@angular/core';
import Chart from 'chart.js';
import {ActivatedRoute, Router} from '@angular/router';
import {GlobalServices} from '../../shared/services/global.services';
import {environment} from '../../../environments/environment';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';


@Component({
    selector: 'dashboard-cmp',
    moduleId: module.id,
    templateUrl: 'dashboard.component.html'
})


export class DashboardComponent implements OnInit{
  filters: FormGroup;
  registerCount;
  empleadosCount;
  tratamientosCount;
  productosCount;


 

  public canvas : any;
  public ctx;
  public chartColor;
  public chartEmail;
  public chartHours;


  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private globalServices: GlobalServices,
    private fb: FormBuilder) {
      this.filters = fb.group({
        registerCount: new FormControl(),
        empleadoCount: new FormControl(),
        productosCount: new FormControl(),
        tratamientoCount: new FormControl(),
      });
    }

   
    ngOnInit(){

        const data = {
        };
        this.globalServices.httpServicesResponse(data, environment.Url + 'global/dashboard').subscribe( res => {
          console.log(res.dashboard);
          this.registerCount= res.dashboard.registerCount;
          this.empleadosCount= res.dashboard.empleadosCount;
          this.tratamientosCount= res.dashboard.tratamientosCount;
          this.productosCount= res.dashboard.productosCount;
          
         this.chartEmail.data.datasets[0].data=[res.dashboard.registerCount,res.dashboard.empleadosCount,res.dashboard.tratamientosCount,res.dashboard.productosCount];
         this.chartEmail.update();

          }
        )

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

        // options: {

        //   legend: {
        //     display: false
        //   },

        //   pieceLabel: {
        //     render: 'percentage',
        //     fontColor: ['white'],
        //     precision: 2
        //   },

        //   tooltips: {
        //     enabled: false
        //   },

        //   scales: {
        //     yAxes: [{

        //       ticks: {
        //         display: true
        //       },
        //       gridLines: {
        //         drawBorder: false,
        //         zeroLineColor: "transparent",
        //         color: 'rgba(255,255,255,0.05)'
        //       }

        //     }],

        //     xAxes: [{
        //       barPercentage: 0,
        //       gridLines: {
        //         drawBorder: true,
        //         color: 'rgba(255,255,255,0.1)',
        //         zeroLineColor: "trasnparent"
        //       },
        //       ticks: {
        //         display: false,
        //       }
        //     }]
        //   },
        // }
      });

      var speedCanvas = document.getElementById("speedChart");

      // var dataFirst = {
      //   data: [10, 19, 15, 20, 30, 40, 40, 50, 25, 30, 50, 20],
      //   fill: false,
      //   borderColor: '#fbc658',
      //   backgroundColor: 'transparent',
      //   pointBorderColor: '#fbc658',
      //   pointRadius: 4,
      //   pointHoverRadius: 4,
      //   pointBorderWidth: 8,
      // };

      var dataSecond = {
        data: [1,2,3,4,5,6,7,8,9,10,11,12],
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

      var lineChart = new Chart(speedCanvas, {
        type: 'line',
        hover: true,
        data: speedData,
        options: chartOptions
      });
    }
    
   

      
      //this.chartColor = "#FFFFFF";
      // this.canvas = document.getElementById("chartHours");
      // this.ctx = this.canvas.getContext("2d");

      // this.chartHours = new Chart(this.ctx, {
      //   type: 'line',

      //   data: {
      //     labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct"],
      //     datasets: [{
      //         borderColor: "#6bd098",
      //         backgroundColor: "#6bd098",
      //         pointRadius: 0,
      //         pointHoverRadius: 0,
      //         borderWidth: 3,
      //         data: [300, 310, 316, 322, 330, 326, 333, 345, 338, 354]
      //       },
      //       {
      //         borderColor: "#f17e5d",
      //         backgroundColor: "#f17e5d",
      //         pointRadius: 0,
      //         pointHoverRadius: 0,
      //         borderWidth: 3,
      //         data: [320, 340, 365, 360, 370, 385, 390, 384, 408, 420]
      //       },
      //       {
      //         borderColor: "#fcc468",
      //         backgroundColor: "#fcc468",
      //         pointRadius: 0,
      //         pointHoverRadius: 0,
      //         borderWidth: 3,
      //         data: [370, 394, 415, 409, 425, 445, 460, 450, 478, 484]
      //       }
      //     ]
      //   },
      //   options: {
      //     legend: {
      //       display: true
      //     },

      //     tooltips: {
      //       enabled: false
      //     },

      //     scales: {
      //       yAxes: [{

      //         ticks: {
      //           fontColor: "#9f9f9f",
      //           beginAtZero: false,
      //           maxTicksLimit: 5,
      //           //padding: 20
      //         },
      //         gridLines: {
      //           drawBorder: true,
      //           zeroLineColor: "black",
      //           color: 'rgba(255,255,255,0.05)'
      //         }

      //       }],

      //       xAxes: [{
      //         barPercentage: 1.6,
      //         gridLines: {
      //           drawBorder: true,
      //           color: 'rgba(255,255,255,0.1)',
      //           zeroLineColor: "black",
      //           display: true,
      //         },
      //         ticks: {
      //           padding: 20,
      //           fontColor: "#9f9f9f"
      //         }
      //       }]
      //     },
      //   }
      // });

}


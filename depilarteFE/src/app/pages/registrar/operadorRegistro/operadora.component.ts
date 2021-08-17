import { Component, OnInit } from '@angular/core';
import { AppModule } from '../../../app.module';



interface Operadora {
    value: string;
    viewValue: string;
  }
  interface Pago {
    value: string;
    viewValue: string;
  }
  interface Zona {
    value: string;
    viewValue: string;
  }
@Component({
    selector: 'user-cmp',
    moduleId: module.id,
    templateUrl: 'operadora.component.html'
})

export class OperadoraComponent implements OnInit{
    private appModule: AppModule;
    ngOnInit(){
    }
    operadora: Operadora[] = [
        {value: 'operadora-0', viewValue: 'Maria'},
        {value: 'operadora-1', viewValue: 'Anna'},
        {value: 'operadora-2', viewValue: 'Juan'}
      ];

      pago: Pago[] = [
        {value: 'pago-0', viewValue: 'Efectivo'},
        {value: 'pago-1', viewValue: 'Zelle'},
        {value: 'pago-2', viewValue: 'Bolivares'}
      ];
      zona: Zona[] = [
        {value: 'zona-0', viewValue: 'Bozo'},
        {value: 'zona-1', viewValue: 'Barbilla'},
        {value: 'zona-2', viewValue: 'Cuello'},
        {value: 'zona-3', viewValue: 'Axilas'},
        {value: 'zona-4', viewValue: 'Linea/Bikini'},
        {value: 'zona-5', viewValue: 'Bikini'},
        {value: 'zona-6', viewValue: 'Brasilero'},
        {value: 'zona-7', viewValue: 'Pantorrilla'},
        {value: 'zona-8', viewValue: 'Piernas Completas'},
        {value: 'zona-9', viewValue: 'Glúteos'},
        {value: 'zona-10', viewValue: 'Brazos'},
        {value: 'zona-11', viewValue: 'Ante Brazos'}
      ];
    uploadFile(event){
        const file= event.target.files[0];
        const dir = './../../../assets/img';


    }
}

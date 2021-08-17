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
  interface Tratamiento {
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
      tratamiento: Tratamiento[] = [
        {value: 'tratamiento-0', viewValue: 'Bozo'},
        {value: 'tratamiento-1', viewValue: 'Barbilla'},
        {value: 'tratamiento-2', viewValue: 'Cuello'}
      ];
    uploadFile(event){
        const file= event.target.files[0];
        const dir = './../../../assets/img';


    }
}

import { Component, OnInit } from '@angular/core';
import { AppModule } from '../../../app.module';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';



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

  interface Tratamiento {
    value: string;
    viewValue: string;
  }
  interface ZonaDra {
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
    form: FormGroup;
   userList = [
     {value: 1, desc: 'Doctora'},
     {value: 2, desc: 'Operadora'}
   ];

   disabled = true;
   showOperative: boolean = true;
   showDoctor: boolean = true;
    ngOnInit() {
      this.showDoctor = false;
      this.showOperative = false;
    }

    constructor(
      private fb: FormBuilder,
      private router: Router,
      private route: ActivatedRoute,
    ) {
      this.form = fb.group({
        userRegister: new FormControl('',[Validators.required]),
        name: new FormControl(),
        lastName: new FormControl(),
        identification: new FormControl(),
        age: new FormControl(),
        phone: new FormControl(),
        email: new FormControl(),
        birthday: new FormControl(),
        address: new FormControl(),
        treatment: new FormControl(),
        treatmentType: new FormControl(),
        treatmentZone: new FormControl(),
        sessions: new FormControl(),
        assistent: new FormControl(),
        product: new FormControl(),
        beforeShots: new FormControl(),
        afterShots: new FormControl(),
        diferents: new FormControl(),
        userOp: new FormControl(),
        userDoc: new FormControl(),
        payment: new FormControl(),
        bono: new FormControl(),
        totalPrice: new FormControl(),
        comission: new FormControl(),
        note: new FormControl()
        });
      this.form.controls.userRegister.valueChanges.subscribe(
        value => {
          switch(value){
            case 1:
              this.showDoctor = true;
              this.showOperative = false;
              break;
            case 2:
              this.showDoctor = false;
              this.showOperative = true;
              break;
          }
        });
    }



    /**operadora: Operadora[] = [
        {value: 'operadora-0', viewValue: 'Francis Reyes'},
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

      zonaDra: ZonaDra[]=[
        {value: 'zonaDra-0', viewValue: 'Rostro tercio superior'},
        {value: 'zonaDra-1', viewValue: 'Axilas (hiperhidrosis)'},
        {value: 'zonaDra-1', viewValue: 'Axilas (hiperhidrosis)'},
        {value: 'zonaDra-1', viewValue: 'Axilas (hiperhidrosis)'},
        {value: 'zonaDra-1', viewValue: 'Axilas (hiperhidrosis)'},
        {value: 'zonaDra-1', viewValue: 'Axilas (hiperhidrosis)'},
        {value: 'zonaDra-1', viewValue: 'Axilas (hiperhidrosis)'},

      ]

      tratamiento: Tratamiento[]=[
        {value: 'tratamiento-0', viewValue: 'Botox'},
        {value: 'tratamiento-0', viewValue: 'Acido hialuronico'},
        {value: 'tratamiento-0', viewValue: 'Plasma Rico en Plaquetas'},
        {value: 'tratamiento-0', viewValue: 'Limpieza facial básica'},
        {value: 'tratamiento-0', viewValue: 'Limpieza facial profunda'},
        {value: 'tratamiento-0', viewValue: 'Extracción de verrugas'},
        {value: 'tratamiento-0', viewValue: 'Quemadores de grasa'},
        {value: 'tratamiento-0', viewValue: 'Botox'},
        {value: 'tratamiento-0', viewValue: 'Botox'},

      ]**/

    uploadFile(event){
        const file= event.target.files[0];
        const dir = './../../../assets/img';
    }
}

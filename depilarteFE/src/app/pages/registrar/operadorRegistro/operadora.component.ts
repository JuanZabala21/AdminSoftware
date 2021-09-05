import { Component, OnInit } from '@angular/core';
import { AppModule } from '../../../app.module';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {environment} from '../../../../environments/environment';
import {GlobalServices} from '../../../shared/services/global.services';

@Component({
    selector: 'user-cmp',
    moduleId: module.id,
    templateUrl: 'operadora.component.html',
    styleUrls: ['operadora.component.scss']
})

export class OperadoraComponent implements OnInit {
    private appModule: AppModule;
    form: FormGroup;
   userList = [
     {value: 1, desc: 'Doctora'},
     {value: 2, desc: 'Operadora'}
   ];
   chargerList = [];
   methodsList = [];
   treatmentTypeList = [];
   treatmentZoneList = [];
   treatmentsList = [];
   productList = [];
   disabled = true;
   show : boolean = true;
   showOperative: boolean = true;
   showDoctor: boolean = true;
    ngOnInit() {
      this.showDoctor = false;
      this.showOperative = false;
      this.getMethodsPay();
      this.getTreatments();
      this.getProduct();
    }

    constructor(
      private fb: FormBuilder,
      private router: Router,
      private route: ActivatedRoute,
      private globalService: GlobalServices
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
        formPay: new FormControl(),
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
    register() {
      if(this.form.invalid) return;
      console.log(this.form.value);
      let data = {
        ...this.form.value
      };
      this.globalService.httpServicesResponse(data, environment.Url + '/depilarte/registerClient').subscribe(
        res => {
          console.log(this.form.value);
          this.router.navigate(['../'], {relativeTo: this.route})
        },
          console.log)
    }
    hasError(control: string, type: string){
      return this.form.controls[control].hasError(type)
    }

    getMethodsPay() {
      this.globalService.httpServicesResponse(null,
        environment.Url + '/global/methodsPay').subscribe( response => {
          if (response.type === 'success') {
            this.methodsList = response.methodsPay.filter(mp => mp.id !== -1);
            }
          },
      console.error);
  }

  changeCharger() {
    if(this.form.get('userRegister').value != null){
      this.globalService.httpServicesResponse({ charger : this.form.get('userRegister').value},
        environment.Url + '/global/chargers').subscribe(response => {
          if (response.type === 'success') {
            this.chargerList = response.chargers.filter(ch => ch.id !== -1);
            console.log(this.chargerList);
          }
        },
        console.log)
    } else {
      return false;
    }
  }

  changeTypeTreament() {
      if(this.form.get('treatment').value != null){
        this.globalService.httpServicesResponse({ treatmentType : this.form.get('treatment').value},
          environment.Url + '/global/treatmentTypes').subscribe(response => {
            if(response.type === 'success') {
              this.treatmentTypeList = response.treatmentTypes.filter(tp => tp.id !== -1);
            }
        },
          console.log)
      } else {
        return false;
      }
    if(this.form.get('treatment').value != null) {
      this.globalService.httpServicesResponse({ treatmentZone : this.form.get('treatment').value},
        environment.Url + '/global/treatmentZone').subscribe(response => {
          if(response.type === 'success') {
            this.treatmentZoneList = response.treatmentZone.filter(tz => tz.id !== -1);
            console.log(this.treatmentZoneList);
          }
        },
        console.log)
    } else {
      return false;
    }

  }

  getTreatments() {
    this.globalService.httpServicesResponse(null,
      environment.Url + '/global/treatments').subscribe( response => {
        if (response.type === 'success') {
          this.treatmentsList = response.treatments.filter(te => te.id !== -1);
          console.log(this.treatmentsList);
        }
      },
      console.error);
  }

  
  getProduct() {
    this.globalService.httpServicesResponse(null,
      environment.Url + '/global/products').subscribe( response => {
        if (response.type === 'success') {
          this.productList = response.products.filter(po => po.id !== -1);
          console.log(this.productList);
        }
      },
      console.error);
  }


}

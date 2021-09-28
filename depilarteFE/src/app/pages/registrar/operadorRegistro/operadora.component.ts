import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {environment} from '../../../../environments/environment';
import {GlobalServices} from '../../../shared/services/global.services';

declare let alertify: any;

@Component({
    selector: 'user-cmp',
    moduleId: module.id,
    templateUrl: 'operadora.component.html',
    styleUrls: ['operadora.component.scss']
})

export class OperadoraComponent implements OnInit {
    form: FormGroup;
  idPoint;
  isLoading = false;
  create = true;
  edit = false;
  total = {
    disparoAntes: 0,
    disparoDespues: 0,
  };
   userList = [
     {value: 1, desc: 'Doctora'},
     {value: 2, desc: 'Operadora'}
   ];
   prices: null;
   referenceList = [];
   chargerList = [];
   methodsList = [];
   treatmentTypeList = [];
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
      this.changeTypeTreament();
      this.changeCharger();
      this.getReference();
      this.form.controls['totalPrice'].disable();
      this.form.controls['diferents'].disable();
      this.form.controls['comission'].disable();

      this.route.queryParams.subscribe( params => {
        const {id} = params;
        this.idPoint = id;
        if (this.idPoint) {
          this.getDtaByUpdate(id);
        }
      });

    }

    constructor(
      private fb: FormBuilder,
      private router: Router,
      private route: ActivatedRoute,
      private globalService: GlobalServices
    ) {
      this.form = fb.group({
        id: new FormControl(),
        userRegister: new FormControl('',[Validators.required]),
        name: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z0-9\\s]+')]),
        lastName: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z0-9\\s]+')]),
        identification: new FormControl('', [Validators.required, Validators.compose([Validators.pattern("^[0-9-,]*$")])]),
        age: new FormControl(),
        phone: new FormControl('', [Validators.required, Validators.compose([Validators.pattern("^[0-9-,]*$")])]),
        email: new FormControl('',[Validators.required]),
        birthday: new FormControl('',[Validators.required]),
        address: new FormControl('',[Validators.required]),
        treatment: new FormControl('',[Validators.required]),
        treatmentType: new FormControl('',[Validators.required]),
        sessions: new FormControl('', [Validators.compose([Validators.pattern("^[0-9-,]*$")])]),
        assistent: new FormControl(),
        product: new FormControl(),
        beforeShots: new FormControl(),
        afterShots: new FormControl(),
        diferents: new FormControl(),
        userOp: new FormControl(),
        userDoc: new FormControl(),
        formPay: new FormControl('',[Validators.required]),
        bono: new FormControl('', [Validators.required, Validators.compose([Validators.pattern("^[0-9-,]*$")])]),
        totalPrice: new FormControl('', [Validators.required, Validators.compose([Validators.pattern("^[0-9-,]*$")])]),
        comission: new FormControl('', [Validators.required, Validators.compose([Validators.pattern("^[0-9-,]*$")])]),
        reference: new FormControl(),
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

  get f() {return this.form.controls; }
  getDtaByUpdate(id) {
    this.isLoading = true;
    const data = {
      id
    };
    this.globalService.httpServicesResponse(data,
      environment.Url + 'depilarte/getPacientes').subscribe(
      res => {
        this.setValues(res);
        this.isLoading = false;
        this.create = false;
        this.edit = true;
      },
      e => {
        this.isLoading = false;
      });
  }

  setValues(values) {
    this.form.setValue(values);
  }

    register() {
      this.form.controls['totalPrice'].enable();
      this.form.controls['diferents'].enable();
      this.form.controls['comission'].enable();
      if(this.form.invalid) return;
      let data = {
        ...this.form.value
      };
      this.globalService.httpServicesResponse(data, environment.Url + '/depilarte/registerClient').subscribe(
        res => {
            if(res.type==='error'){
              this.form.controls['totalPrice'].disable();
              this.form.controls['diferents'].disable();
              this.form.controls['comission'].disable();
          alertify.error('Error al registrar');
       }else{
              this.form.controls['totalPrice'].disable();
              this.form.controls['diferents'].disable();
              this.form.controls['comission'].disable();
          this.form.reset();
       alertify.success('Registrado con exito');
       }
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
            this.chargerList = response.chargers.filter(ch => ch.id !== -1);
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
              this.treatmentTypeList = response.treatmentTypes.filter(tp => tp.id !== -1);

        },
          console.log)
      } else {
        return false;
      }
  }

  changePriceAndComision() {
    if(this.form.get('treatmentType').value != null){
      this.globalService.httpServicesResponse({ priceAndComision : this.form.get('treatmentType').value},
        environment.Url + '/global/priceAndComision').subscribe(response => {
            this.prices = response.priceResult.precioTratamiento;
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
        }
      },
      console.error);
  }


  getProduct() {
    this.globalService.httpServicesResponse(null,
      environment.Url + '/global/products').subscribe( response => {
        if (response.type === 'success') {
          this.productList = response.products.filter(po => po.id !== -1);
        }
      },
      console.error);
  }

  getReference() {
    this.globalService.httpServicesResponse(null,
      environment.Url + '/global/reference').subscribe( response => {
        if (response.type === 'success') {
          this.referenceList = response.reference.filter(rf => rf.id !== -1);
        }
      },
      console.error);
  }

}

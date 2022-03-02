import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {environment} from '../../../../environments/environment';
import {GlobalServices} from '../../../shared/services/global.services';
import { DomSanitizer } from '@angular/platform-browser';

declare let alertify: any;

@Component({
    selector: 'user-cmp',
    moduleId: module.id,
    templateUrl: 'operadora.component.html',
    styleUrls: ['operadora.component.scss']
})

export class OperadoraComponent implements OnInit {
    form: FormGroup;
    afterImage;
    beforeImage;
    baseBeforeImage;
    baseAfterImage;
  idPoint;
  isHistory;
  isLoading = false;
  create = true;
  edit = false;
  total = {
    disparoAntes: 0,
    disparoDespues: 0,
  };

imageName: any;
selectedFileAfter: File;
selectedFileBefore: File;
  precio = {
    prices: 0,
    abonado: 0,
  };
   userList = [
     {value: 1, desc: 'Doctora'},
     {value: 2, desc: 'Operadora'}
   ];
   comissionPrice: null;
   referenceList = [];
   chargerList = [];
   methodsList = [];
   treatmentTypeList = [];
   treatmentsList = [];
   workersList = [];
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
      this.form.controls['beforeShots'].disable();
      this.form.controls['paymentFavor'].disable();
      this.form.controls['diferents'].disable();
      this.form.controls['comission'].disable();
      console.log(this.form.controls.treatmentType.value);
      this.route.queryParams.subscribe( params => {
        const {id} = params;
        const {history} = params;
        this.isHistory = history;
        this.idPoint = id;
        if (this.isHistory) {
          this.getDtaByUpdate(id, history);
        } else {
          if (this.idPoint) {
            this.getDtaByUpdate(id, null);
          }
        }
      });

    }

    constructor(
      private fb: FormBuilder,
      private router: Router,
      private route: ActivatedRoute,
      private globalService: GlobalServices,
      private sanitizer: DomSanitizer,
    ) {
      this.form = fb.group({
        id: new FormControl(),
        userRegister: new FormControl('',[Validators.required]),
        name: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z0-9\\s]+')]),
        lastName: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z0-9\\s]+')]),
        identification: new FormControl('', [Validators.required, Validators.compose([Validators.pattern("^[0-9-,]*$")])]),
        age: new FormControl('',[Validators.required]),
        phone: new FormControl('', [Validators.required, Validators.compose([Validators.pattern("^[0-9-,]*$")])]),
        email: new FormControl('',[Validators.required]),
        birthday: new FormControl('',[Validators.required]),
        address: new FormControl('',[Validators.required]),
        treatment: new FormControl('',[Validators.required]),
        treatmentType: new FormControl('',[Validators.required]),
        sessions: new FormControl('', [Validators.compose([Validators.pattern("^[0-9-,]*$")])]),
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
        reference: new FormControl('',[Validators.required]),
        note: new FormControl(),
        imageAfter: new FormControl(),
        imageBefore: new FormControl(),
        history: new FormControl(),
        paymentFavor: new FormControl()
        });
      this.form.controls.userRegister.valueChanges.subscribe(
        value => {
          switch (value) {
            case 1:
              this.showDoctor = true;
              this.showOperative = false;
              this.form.controls.sessions.setValidators(Validators.required);
              this.form.controls.product.setValidators(Validators.required);
              this.form.controls.userDoc.setValidators(Validators.required);
              break;
            case 2:
              this.showDoctor = false;
              this.showOperative = true;
              this.form.controls.beforeShots.setValidators(Validators.required);
              this.form.controls.afterShots.setValidators(Validators.required);
              this.form.controls.diferents.setValidators(Validators.required);
              this.form.controls.userOp.setValidators(Validators.required);
              break;
          }
        });
    }

  get f() {return this.form.controls; }
  getDtaByUpdate(id, history) {
    this.isLoading = true;
    const data = {
      id,
      history
    };
    this.globalService.httpServicesResponse(data,
      environment.Url + 'depilarte/getPacientes').subscribe(
      res => {
        console.log(res);
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
      if (values.history == null ) {
        this.total.disparoAntes = values.beforeShots;
        this.total.disparoDespues = values.afterShots;
        if (values.imageAfter != null) {
          this.baseAfterImage = values.imageAfter;
          this.baseTransformAfter(this.baseAfterImage);
        }
        if (values.imageBefore != null) {
          this.baseBeforeImage = values.imageBefore;
          this.baseTransformBefore(this.baseBeforeImage);
        }
      }
      this.form.setValue(values);
  }

    register() {
      if(this.form.invalid) return;
      this.form.controls['totalPrice'].enable();
      this.form.controls['diferents'].enable();
      this.form.controls['comission'].enable();
      this.form.controls['beforeShots'].enable();
      this.form.controls['paymentFavor'].enable();
      let data = {
        imageFileAfter: this.afterImage,
        imageFileBefore: this.beforeImage,
        ...this.form.value,
      };

      this.globalService.httpServicesResponse(data, environment.Url + '/depilarte/registerClient').subscribe(
        res => {
            if(res.type==='error'){
              alertify.error('Error al registrar');
              this.form.controls['totalPrice'].disable();
              this.form.controls['diferents'].disable();
              this.form.controls['comission'].disable();
              this.form.controls['beforeShots'].disable();
              this.form.controls['paymentFavor'].disable();
       }else{
              alertify.success('Registrado con exito');
              this.precio.prices = 0;
              this.beforeImage = "";
              this.afterImage = "";
              this.form.reset();
              this.form.controls['totalPrice'].disable();
              this.form.controls['diferents'].disable();
              this.form.controls['comission'].disable();
              this.form.controls['beforeShots'].disable();
              this.form.controls['paymentFavor'].disable();
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
            this.total.disparoAntes = response.gunValueResult;

        },
        console.log)
    } else {
      return false;
    }
  }

  changeTypeTreament() {
      if(this.form.get('treatment').value != null) {
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
    if(this.form.get('treatmentType').value != null) {
      this.globalService.httpServicesResponse({ priceAndComision : this.form.get('treatmentType').value},
        environment.Url + '/global/priceAndComision').subscribe(response => {
            this.precio.prices = response.priceResult.precioTratamiento;
            this.comissionPrice = response.priceResult.comission;
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

  public onFileChangedAfter(event) {
    let me = this;
    let file = event.target.files[0];
    let reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = function () {
      me.afterImage = reader.result;
    };
    reader.onerror = function (error) {
      console.log('Error: ', error);
    };
  }

  public onFileChangedBefore(event) {
    let me = this;
    let file = event.target.files[0];
    let reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = function () {
      me.beforeImage = reader.result;
    };
    reader.onerror = function (error) {
      console.log('Error: ', error);
    };
  }

  public baseTransformAfter(paramAfter) {
      if(paramAfter.includes("{changingThisBreaksApplicationSecurity=") && paramAfter.includes("}")){
        let afterParam = paramAfter.split("{changingThisBreaksApplicationSecurity=")[1]
        afterParam = afterParam.split("}")[0];
        let mySrcAfter = this.sanitizer.bypassSecurityTrustUrl(afterParam);
        this.afterImage = mySrcAfter;
      }else{
        let mySrcAfter = this.sanitizer.bypassSecurityTrustUrl(paramAfter);
        this.afterImage = mySrcAfter;
      }

  }

  public baseTransformBefore(paramBefore) {
      if(paramBefore.includes("{changingThisBreaksApplicationSecurity=") && paramBefore.includes("}")){
        let beforeParam = paramBefore.split("{changingThisBreaksApplicationSecurity=")[1]
        beforeParam = beforeParam.split("}")[0];
        let mySrcABefore = this.sanitizer.bypassSecurityTrustUrl(beforeParam);
        this.beforeImage = mySrcABefore;
      }else{
        let mySrcABefore = this.sanitizer.bypassSecurityTrustUrl(paramBefore);
        this.beforeImage = mySrcABefore;
      }


  }


}

import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {GlobalServices} from '../../../shared/services/global.services';
import {AppModule} from '../../../app.module';
import {environment} from '../../../../environments/environment';

interface usuarioList {
  value: number;
  desc: string;
}

declare let alertify: any;

@Component({
  selector: 'app-tratamientoRegistrar',
  templateUrl: './tratamientoRegistrar.component.html',
  styleUrls: ['./tratamientoRegistrar.component.scss']
})

export class TratamientoRegistrarComponent implements OnInit {
  private appModule: AppModule;
  form: FormGroup;
  idPoint;
  typeList = [];
  isLoading = false;
  create = true;
  edit = false;
  user: usuarioList[] = [
    {value: 1, desc: 'Doctora'},
    {value: 2, desc: 'Operadora'}
    ];

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private globalService: GlobalServices)
  {
    this.form = fb.group({
      id: new FormControl(),
      treatmentName: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z0-9\\s]+')]),
      specialist: new FormControl('',[Validators.required]),
      sessions: new FormControl('',[Validators.required]),
      typePrice: this.fb.array([],[Validators.required]),
      comission: new FormControl('',[Validators.required]),
      description: new FormControl()
    });
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe( params => {
      const {id} = params;
      this.idPoint = id;
      if (this.idPoint) {
        this.getDtaByUpdate(id);
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
      environment.Url + 'depilarte/getTreatment').subscribe(
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
    this.typeList = values.typePrice;
    values.typePrice.forEach(element => {
      const typePriceFormGroup = this.fb.group({
        typeTreatment: '',
        typePrice: ''
      });
      this.typePrices.push(typePriceFormGroup);
    });

    this.form.setValue(values);
  }

  register() {
    if(this.form.invalid) return;
    let data = {
      ...this.form.value
    };
    this.globalService.httpServicesResponse(data, environment.Url + '/depilarte/registerTreatment').subscribe(
      res => {
        if(res.type==='error'){
          alertify.error('Error al registrar');
       }else{
          this.form.reset();
       alertify.success('Registrado con exito');
       }

      },
      console.log)
  }
  hasError(control: string, type: string){
    return this.form.controls[control].hasError(type)
  }

  get typePrices() {
    return this.form.get('typePrice') as FormArray;
  }

  addTypePrice() {
    const typePriceFormGroup = this.fb.group({
      typeTreatment: '',
      typePrice: ''
    });
    this.typePrices.push(typePriceFormGroup);
    this.typeList.push(typePriceFormGroup);
  }

  removeTypePice(indice: number) {
    this.typePrices.removeAt(indice);
  }

}

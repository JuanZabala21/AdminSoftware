import { Component, OnInit } from '@angular/core';
import {environment} from '../../../../environments/environment';
import {AppModule} from '../../../app.module';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {GlobalServices} from '../../../shared/services/global.services';


interface usuarioList {
  value: number;
  desc: string;
}

declare let alertify: any;

@Component({
  selector: 'app-registrar-producto',
  templateUrl: './registrar-producto.component.html',
  styleUrls: ['./registrar-producto.component.scss']
})
export class RegistrarProductoComponent implements OnInit {
  private appModule: AppModule;
  form: FormGroup;
  treatmentsList = [];
  idPoint;
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
    private globalService: GlobalServices
  ) {
    this.form = fb.group({
      id: new FormControl(),
      product: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z0-9\\s]+')]),
      proveedor: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z0-9\\s]+')]),
      cantidad: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z0-9\\s]+')]),
      specialist: new FormControl('',[Validators.required]),
      price: new FormControl('',[Validators.required]),
      description: new FormControl()
      }
    )
  }

  ngOnInit(): void {
    this.getTreatments();

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
      environment.Url + 'depilarte/getProducts').subscribe(
      res => {
        console.log(res);
        this.setValues(res);
        this.isLoading = false;
        this.create = false;
        this.edit = true;
      },
      e => {
        console.log(e);
        this.isLoading = false;
      });
  }

  setValues(values) {
    this.form.setValue(values);
  }


  register() {
    if(this.form.invalid) return;
    console.log(this.form.value);
    let data = {
      ...this.form.value
    };
    this.globalService.httpServicesResponse(data, environment.Url + '/depilarte/registerProduct').subscribe(
      res => {
        if(res.type==='error'){
           alertify.error('Error al registrar');
        }else{
          console.log(this.form.value);
           this.form.reset();
        alertify.success('Registrado con exito');
        }

      },
      console.log)
  }
  hasError(control: string, type: string) {
    return this.form.controls[control].hasError(type)
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



}

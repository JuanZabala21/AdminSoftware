import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import {environment} from '../../../../environments/environment';
import {GlobalServices} from '../../../shared/services/global.services';
import {AppModule} from '../../../app.module';

declare let alertify: any;
@Component({
  selector: 'app-usuario-registro',
  templateUrl: './usuario-registro.component.html',
  styleUrls: ['./usuario-registro.component.scss']
})
export class UsuarioRegistroComponent implements OnInit {
  private appModule: AppModule;
  form: FormGroup;
  idPoint;
  isLoading = false;
  create = true;
  edit = false;
  userList = [
    {value: 1, desc: 'Doctora'},
    {value: 2, desc: 'Operadora'}
  ];
  ngOnInit(): void {

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
    private globalService: GlobalServices,
  ) {
    this.form = fb.group({
      id: new FormControl(),
      name: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z0-9\\s]+')]),
      lastName: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z0-9\\s]+')]),
      identification: new FormControl('', [Validators.required, Validators.compose([Validators.pattern("^[0-9-,]*$")])]),
      age: new FormControl('',[Validators.required]),
      phone: new FormControl('', [Validators.required, Validators.compose([Validators.pattern("^[0-9-,]*$")])]),
      email: new FormControl('',[Validators.required]),
      birthday: new FormControl('',[Validators.required]),
      address: new FormControl('',[Validators.required]),
      charge: new FormControl('',[Validators.required])
      });
}
get f() {return this.form.controls; }
getDtaByUpdate(id) {
    this.isLoading = true;
    const data = {
      id
    };
    this.globalService.httpServicesResponse(data,
      environment.Url + 'depilarte/getEmpleados').subscribe(
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
if(data){
  this.form.controls.charge.patchValue(data.charge);
}

  register() {
    if(this.form.invalid) return;
    let data = {
      ...this.form.value
    };
    this.globalService.httpServicesResponse(data, environment.Url + '/depilarte/registerEmpleado').subscribe(
      res => {  if(res.type==='error'){
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
}

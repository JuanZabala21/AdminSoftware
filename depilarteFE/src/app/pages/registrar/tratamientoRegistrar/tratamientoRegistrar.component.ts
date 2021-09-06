import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
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
      treatmentName: new FormControl(),
      typeTreatment: new FormControl(),
      zoneTreatment: new FormControl(),
      specialist: new FormControl(),
      sessions: new FormControl(),
      price: new FormControl(),
      comission: new FormControl(),
      description: new FormControl()
    });
  }

  ngOnInit(): void {

  }

  register() {
    if(this.form.invalid) return;
    console.log(this.form.value);
    let data = {
      ...this.form.value
    };
    this.globalService.httpServicesResponse(data, environment.Url + '/depilarte/registerTreatment').subscribe(
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
  hasError(control: string, type: string){
    return this.form.controls[control].hasError(type)
  }

}

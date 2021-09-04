import { Component, OnInit } from '@angular/core';
import {environment} from '../../../../environments/environment';
import {AppModule} from '../../../app.module';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {GlobalServices} from '../../../shared/services/global.services';


interface usuarioList {
  value: number;
  desc: string;
}

@Component({
  selector: 'app-registrar-producto',
  templateUrl: './registrar-producto.component.html',
  styleUrls: ['./registrar-producto.component.scss']
})
export class RegistrarProductoComponent implements OnInit {
  private appModule: AppModule;
  form: FormGroup;
  treatmentsList = [];


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
      product: new FormControl(),
      proveedor: new FormControl(),
      cantidad: new FormControl(),
      specialist: new FormControl(),
      price: new FormControl(),
      description: new FormControl()
      }
    )
  }

  ngOnInit(): void {
    this.getTreatments();
  }

  register() {
    if(this.form.invalid) return;
    console.log(this.form.value);
    let data = {
      ...this.form.value
    };
    this.globalService.httpServicesResponse(data, environment.Url + '/depilarte/registerProduct').subscribe(
      res => {
        console.log(this.form.value);
        this.router.navigate(['../'], {relativeTo: this.route})
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

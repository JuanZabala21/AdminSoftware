import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import {environment} from '../../../../environments/environment';
import {GlobalServices} from '../../../shared/services/global.services';
import {AppModule} from '../../../app.module';

@Component({
  selector: 'app-usuario-registro',
  templateUrl: './usuario-registro.component.html',
  styleUrls: ['./usuario-registro.component.scss']
})
export class UsuarioRegistroComponent implements OnInit {
  private appModule: AppModule;
  form: FormGroup;
  ngOnInit(): void {
  }
  constructor(
    private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private globalService: GlobalServices,
  ) {
    this.form = fb.group({
      userRegister: new FormControl(),
      name: new FormControl(),
      lastName: new FormControl(),
      identification: new FormControl(),
      age: new FormControl(),
      phone: new FormControl(),
      email: new FormControl(),
      birthday: new FormControl(),
      address: new FormControl(),
      cargo: new FormControl()
      });
}

  register() {
    if(this.form.invalid) return;
    console.log(this.form.value);
    let data = {
      ...this.form.value
    };
    this.globalService.httpServicesResponse(data, environment.Url + '/depilarte/registerEmpleado').subscribe(
      res => {
        console.log(this.form.value);
        this.router.navigate(['../principal'], {relativeTo: this.route})
      },
      console.log)
  }
  hasError(control: string, type: string){
    return this.form.controls[control].hasError(type)
  }




}

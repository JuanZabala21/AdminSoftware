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
    register() {
      if(this.form.invalid) return;
      console.log(this.form.value);
      let data = {
        ...this.form.value
      };
      this.globalService.httpServicesResponse(data, environment.Url + '/registerClient').subscribe(
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

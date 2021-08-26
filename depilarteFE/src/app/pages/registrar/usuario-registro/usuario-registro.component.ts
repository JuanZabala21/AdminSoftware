import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-usuario-registro',
  templateUrl: './usuario-registro.component.html',
  styleUrls: ['./usuario-registro.component.scss']
})
export class UsuarioRegistroComponent implements OnInit {
  form: FormGroup;

  ngOnInit(): void {
  }
  constructor(
    private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
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
      cargo: new FormControl()
      });
}
}

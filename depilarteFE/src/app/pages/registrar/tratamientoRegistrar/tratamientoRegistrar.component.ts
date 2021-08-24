import { Component, OnInit } from '@angular/core';

interface usuarioList {
  value: number;
  desc: string;
}

@Component({
  selector: 'app-tratamientoRegistrar',
  templateUrl: './tratamientoRegistrar.component.html',
  styleUrls: ['./tratamientoRegistrar.component.scss']
})

export class TratamientoRegistrarComponent implements OnInit {
  user: usuarioList[] = [
    {value: 1, desc: 'Doctora'},
    {value: 2, desc: 'Operadora'}
    ];

  constructor() { }

  ngOnInit(): void {
  }

}

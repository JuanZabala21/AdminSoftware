import { Component, OnInit } from '@angular/core';


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

  user: usuarioList[] = [
    {value: 1, desc: 'Doctora'},
    {value: 2, desc: 'Operadora'}
    ];

  constructor() { }

  ngOnInit(): void {
  }

}

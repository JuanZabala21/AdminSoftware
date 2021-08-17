import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {ActivatedRoute, Router} from '@angular/router';
import {MatSort} from '@angular/material/sort';

interface HistorialData {
  dateA: String;
  name: String;
  lastName: String,
  identification: String,
  age: String,
  treatment: String;
  treatmentZone: String,
  pistolBefore: String,
  pistolAfter: String,
  diferentShot: String,
  countSession: String,
  operator: String,
  assistent: String,
  product: String,
  doctor: String,
  payForm: String,
  subscriber: String,
  comission: String,
  price: String;
}

@Component({
  selector: 'inventario',
  moduleId: module.id,
  templateUrl: 'inventario.component.html',
  styleUrls: ['inventario.component.scss']
})

export class InventarioComponent implements OnInit {
  filters: FormGroup;
  usuarioList = [
    {value: 1, desc: 'Doctora'},
    {value: 2, desc: 'Operadora'}
  ];
  displayedColumns: string[] =
    [
      'dateA',
      'name',
      'lastName',
      'identification',
      'age',
      'treatment',
      'treatmentType',
      'treatmentZone',
      'pistolBefore',
      'pistolAfter',
      'diferentShot',
      'operator',
      'countSession',
      'assistent',
      'product',
      'doctor',
      'payForm',
      'subscriber',
      'comission',
      'price',
      'actions'
    ];

  dataSource: MatTableDataSource<HistorialData>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private fb: FormBuilder,
              private router: Router,
              private route: ActivatedRoute) {
    this.filters = fb.group({
      name: new FormControl(),
      lastName: new FormControl(),
      identification: new FormControl(),
      initialDate: new FormControl(),
      finalDate: new FormControl(),
      user: new FormControl(),
      userName: new FormControl()
    });
  }

  ngOnInit() {
  }
}

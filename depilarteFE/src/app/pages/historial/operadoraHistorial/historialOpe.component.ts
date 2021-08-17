import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {ActivatedRoute, Router} from '@angular/router';
import {MatSort} from '@angular/material/sort';

interface HistorialOperadora {
  dateA: String;
  name: String;
  lastName: String,
  identification: String,
  age: String,
  email: String,
  treatment: String;
  pistolBefore: String,
  pistolAfter: String,
  diferentShot: String,
  operator: String,
  payForm: String,
  subscriber: String,
  comission: String,
  price: String;
}


@Component({
    selector: 'historialOpe',
    moduleId: module.id,
    templateUrl: 'historialOpe.component.html',
    styleUrls: ['historialOpe.component.scss']
  })

  export class HistorialOpeComponent implements OnInit {
  filters: FormGroup;
  displayedColumns: string[] =
    [
      'dateA',
      'name',
      'lastName',
      'identification',
      'age',
      'email',
      'treatment',
      'treatmentType',
      'treatmentZone',
      'pistolBefore',
      'pistolAfter',
      'diferentShot',
      'operator',
      'payForm',
      'subscriber',
      'comission',
      'price',
      'actions'
    ];

  dataSource: MatTableDataSource<HistorialOperadora>;
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
      operator: new FormControl()
    });
  }


  ngOnInit() {
  }
}

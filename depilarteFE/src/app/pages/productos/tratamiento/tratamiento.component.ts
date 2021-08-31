import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {ActivatedRoute, Router} from '@angular/router';
import {MatSort} from '@angular/material/sort';

interface HistorialData {
  treatmentName: String;
  treatmentType: String;
  treatmentZone: String,
  sessions: String,
  priceTreatment: String,
  operativeComission: String;
}

@Component({
  selector: 'tratamiento',
  moduleId: module.id,
  templateUrl: 'tratamiento.component.html',
  styleUrls: ['tratamiento.component.scss']
})

export class TratamientoComponent implements OnInit {
  filters: FormGroup;
  usuarioList = [
    {value: 1, desc: 'Doctora'},
    {value: 2, desc: 'Operadora'}
  ];
  displayedColumns: string[] =
    [
      'treatmentName',
      'treatmentType',
      'treatmentZone',
      'user',
      'sessions',
      'priceTreatment',
      'operativeComission',
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





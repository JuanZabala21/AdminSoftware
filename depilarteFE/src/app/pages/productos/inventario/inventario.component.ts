import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {ActivatedRoute, Router} from '@angular/router';
import {MatSort} from '@angular/material/sort';
import {environment} from '../../../../environments/environment';
import {GlobalServices} from '../../../shared/services/global.services';

interface HistorialData {
  treatmentName: String;
  treatmentType: String;
  treatmentZone: String,
  sessions: String,
  priceTreatment: String,
  operativeComission: String;
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
      'name',
      'prov',
      'quantity',
      'user',
      'treatment',
      'price',
      'actions'
    ];

  dataSource: MatTableDataSource<HistorialData>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private fb: FormBuilder,
              private router: Router,
              private route: ActivatedRoute,
              private globalServices: GlobalServices) {
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

  search() {
    const data = {
      ...this.filters.value
    };
    this.globalServices.httpServicesResponse(data, environment.Url + '/depilarte/searchProducts').subscribe( res => {
        console.log(res.resultList);
        this.dataSource = new MatTableDataSource(res.resultList);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      }
    )
  }
}

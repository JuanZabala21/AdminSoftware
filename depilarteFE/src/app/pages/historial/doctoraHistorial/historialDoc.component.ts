import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {ActivatedRoute, Router} from '@angular/router';
import {MatSort} from '@angular/material/sort';
import {GlobalServices} from '../../../shared/services/global.services';
import {environment} from '../../../../environments/environment';
import {isElementScrolledOutsideView} from '@angular/cdk/overlay/position/scroll-clip';

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
  selector: 'historialDoc',
  moduleId: module.id,
  templateUrl: 'historialDoc.component.html',
  styleUrls: ['historialDoc.component.scss']
})

export class HistorialDocComponent implements OnInit {
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
      'phone',
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
     this.globalServices.httpServicesResponse(data, environment.Url + '/depilarte/searchRegister').subscribe( res => {
       console.log(res.resultList);
       this.dataSource = new MatTableDataSource(res.resultList);
       this.dataSource.paginator = this.paginator;
     this.dataSource.sort = this.sort;
     }
   )


  }
}

import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {ActivatedRoute, Router} from '@angular/router';
import {MatSort} from '@angular/material/sort';
import {GlobalServices} from '../../../shared/services/global.services';
import {environment} from '../../../../environments/environment';
import { saveAs } from 'file-saver';

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
  fileName : string = 'Registros.xlsx';
  chargerList = [];
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
      'birthday',
      'age',
      'phone',
      'treatment',
      'treatmentType',
      'shotsBefore',
      'shotsAfter',
      'shotsDifferential',
      'userAttemption',
      'countSession',
      'assistent',
      'product',
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
        this.dataSource = new MatTableDataSource(res.resultList);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      }
    )
  }

  goEdit(id) {
    this.router.navigate(['/registrar-paciente'],
      { relativeTo: this.route,queryParams:{id}});
  }

  changeCharger() {
    if(this.filters.get('user').value != null){
      this.globalServices.httpServicesResponse({ charger : this.filters.get('user').value},
        environment.Url + '/global/chargers').subscribe(response => {
          this.chargerList = response.chargers.filter(ch => ch.id !== -1);
        },
        console.log)
    } else {
      return false;
    }
  }

  download() {
    const data = {
      ...this.filters.value
    };
    this.globalServices.httpServicesResponse(data,
      environment.Url + 'depilarte/generateRegister').subscribe(
      data => {

        const result: any = data;
        if (result.type == 'error') {
        } else {
          var file = result.resultEncodedString;
          let sliceSize = 512;
          let byteCharacters = atob(file);
          let byteArrays = [];
          for (let offset = 0; offset < byteCharacters.length; offset += sliceSize) {
            let slice = byteCharacters.slice(offset, offset + sliceSize);
            let byteNumbers = new Array(slice.length);
            for (var i = 0; i < slice.length; i++) {
              byteNumbers[i] = slice.charCodeAt(i);
            }
            let byteArray = new Uint8Array(byteNumbers);
            byteArrays.push(byteArray);
          }
          const blob = new Blob(byteArrays, {type: 'application/vnd.ms-excel'});
          saveAs(blob, this.fileName);
        }
      },
      error => {
        //error
      }
    );
  }

}

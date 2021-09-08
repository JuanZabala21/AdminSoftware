import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {ActivatedRoute, Router} from '@angular/router';
import {MatSort} from '@angular/material/sort';
import {environment} from '../../../../environments/environment';
import {GlobalServices} from '../../../shared/services/global.services';
import { saveAs } from 'file-saver';

interface HistorialData {
  name: String;
  lastName: String;
  identification: String,
  age: String,
  email: String,
  phone: String;
  birthday: String;
  address: String;
  cargo: String;
}

@Component({
  selector: 'app-empleado-historial',
  templateUrl: './empleado-historial.component.html',
  styleUrls: ['./empleado-historial.component.scss']
})
export class EmpleadoHistorialComponent implements OnInit {
  filters: FormGroup;
  fileName : string = '';
  treatmentTypeList = [];
  treatmentZoneList = [];
  displayedColumns: string[] =
  [
    'dateA',
    'name',
    'lastName',
    'identification',
    'age',
    'email',
    'phone',
    'birthday',
    'address',
    'cargo',
    'actions'
  ];

  dataSource: MatTableDataSource<HistorialData>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  ngOnInit(): void {
  }

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private globalServices: GlobalServices) {
      this.filters = fb.group({
        name: new FormControl(),
        lastName: new FormControl(),
        identification: new FormControl(),
        age: new FormControl(),
        phone: new FormControl(),
        email: new FormControl(),
        birthday: new FormControl(),
        address: new FormControl(),
        cargo: new FormControl(),
        initialDate: new FormControl(),
        finalDate: new FormControl()
      });
}

  search() {
    const data = {
      ...this.filters.value
    };
    this.globalServices.httpServicesResponse(data, environment.Url + '/depilarte/searchWorker').subscribe( res => {
        console.log(res.resultList);
        this.treatmentTypeList = res.resultList.treatmentType;
        this.dataSource = new MatTableDataSource(res.resultList);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      }
    )
  }


  goEdit(id) {
    this.router.navigate(['/registrar-usuario'],
      { relativeTo: this.route,queryParams:{id}});
}

  download() {
    const data = {
      ...this.filters.value
    };
    this.globalServices.httpServicesResponse(data,
      environment.Url + 'depilarte/generateEmpleados').subscribe(
      data => {

        const result: any = data;
        if (result.type == 'error') {
          console.log('error')
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
          const blob = new Blob(byteArrays, {type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'});
          saveAs(blob, this.fileName);
        }
      },
      error => {
        //error
      }
    );
  }


}

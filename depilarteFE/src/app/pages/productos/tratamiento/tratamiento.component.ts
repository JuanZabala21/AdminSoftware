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
  fileName : string = '';
  treatmentTypeList = [];
  usuarioList = [
    {value: 1, desc: 'Doctora'},
    {value: 2, desc: 'Operadora'}
  ];
  displayedColumns: string[] =
    [
      'treatmentName',
      'treatmentType',
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
    this.globalServices.httpServicesResponse(data, environment.Url + '/depilarte/searchTreatments').subscribe( res => {
        this.dataSource = new MatTableDataSource(res.resultList);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      }
    )
  }

  goEdit(id){
    this.router.navigate(['/registrar-tratamiento'],
      { relativeTo: this.route,queryParams:{id}});
  }


  download() {
    const data = {
      ...this.filters.value
    };
    this.globalServices.httpServicesResponse(data,
      environment.Url + 'depilarte/generateTreatments').subscribe(
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





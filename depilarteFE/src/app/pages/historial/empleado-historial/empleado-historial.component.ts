import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {ActivatedRoute, Router} from '@angular/router';
import {MatSort} from '@angular/material/sort';
import {environment} from '../../../../environments/environment';
import {GlobalServices} from '../../../shared/services/global.services';

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

  constructor(private fb: FormBuilder,
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

  ngOnInit(): void {
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

}

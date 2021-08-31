import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {ActivatedRoute, Router} from '@angular/router';
import {MatSort} from '@angular/material/sort';

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
  displayedColumns: string[] =
  [
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
    private route: ActivatedRoute) {
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

}

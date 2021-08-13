import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {ActivatedRoute, Router} from '@angular/router';
import {MatSort} from '@angular/material/sort';

 interface HistorialData {
  name: String;
  dateA: String;
  treatment: String;
  price: String;
}

@Component({
  selector: 'historial',
  moduleId: module.id,
  templateUrl: 'historial.component.html',
  styleUrls: ['historial.component.scss']
})

export class HistorialComponent implements OnInit {
  filters: FormGroup;
  displayedColumns: string[] =
    [
      'name',
      'dateA',
      'treatment',
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
      identification: new FormControl()
    });
  }

  ngOnInit() {

  }
}

import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {ActivatedRoute, Router} from '@angular/router';
import {MatSort} from '@angular/material/sort';


@Component({
  selector: 'inventario',
  moduleId: module.id,
  templateUrl: 'inventario.component.html',
  styleUrls: ['inventario.component.scss']
})

export class InventarioComponent implements OnInit {




  ngOnInit() {
  }
}

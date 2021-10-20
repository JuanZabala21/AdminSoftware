import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {ActivatedRoute, Router} from '@angular/router';
import {MatSort} from '@angular/material/sort';
import {GlobalServices} from '../../../shared/services/global.services';
import {environment} from '../../../../environments/environment';
import { saveAs } from 'file-saver';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';

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
   product: String,
   doctor: String,
   payForm: String,
   subscriber: String,
   comission: String,
   paymentFavor: String,
   price: String;
}

@Component({
  selector: 'historialDoc',
  moduleId: module.id,
  templateUrl: 'historialDoc.component.html',
  styleUrls: ['historialDoc.component.scss']
})

export class HistorialDocComponent implements OnInit {
  closeResult: string;
  filters: FormGroup;
  fileName : string = 'Registros.xlsx';
  totalPagoM = 0;
  totalZelle = 0;
  totalEfectivo = 0;
  totalAbonado = 0;
  chargerList = [];
  usuarioList = [
    {value: 1, desc: 'Doctora'},
    {value: 2, desc: 'Operadora'}
    ];
  formPayList = [];
  workerList = [];

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
      'product',
      'payForm',
      'subscriber',
      'comission',
      'price',
      'paymentFavor',
      'actions'
    ];

  dataSource: MatTableDataSource<HistorialData>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private fb: FormBuilder,
              private router: Router,
              private route: ActivatedRoute,
              private globalServices: GlobalServices,
              private modalService: NgbModal) {
    this.filters = fb.group({
      name: new FormControl(),
      lastName: new FormControl(),
      identification: new FormControl(),
      initialDate: new FormControl(),
      finalDate: new FormControl(),
      user: new FormControl(),
      userName: new FormControl(),
      formPay: new FormControl()

    });
  }

  ngOnInit() {
    this.getMethodsPay();
    this.getWorkers();
  }

  search() {
    const data = {
      ...this.filters.value
    };
    this.globalServices.httpServicesResponse(data, environment.Url + '/depilarte/searchRegister').subscribe( res => {
        const position = res.resultList.length - 1;
        this.totalZelle = res.resultList[position].zelleTotal;
        this.totalPagoM = res.resultList[position].pagoMTotal;
        this.totalAbonado = res.resultList[position].abonoTotal;
        this.totalEfectivo = res.resultList[position].efectivoTotal;
        res.resultList.pop();
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

  goNew(id,history) {
    this.router.navigate(['/registrar-paciente'],
      { relativeTo: this.route,queryParams:{id,history}});
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

  getMethodsPay() {
    this.globalServices.httpServicesResponse(null,
      environment.Url + '/global/methodsPay').subscribe( response => {
        if (response.type === 'success') {
          this.formPayList = response.methodsPay.filter(mp => mp.id !== -1);
        }
      },
      console.error);
  }

  getWorkers() {
    this.globalServices.httpServicesResponse(null,
      environment.Url + '/global/workersUri').subscribe( response => {
        if (response.type === 'success') {
          this.workerList = response.empleadoResult.filter(we => we.id !== -1);
        }
      },
      console.error);
  }

  open(content, worker) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
     console.log(worker);
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

}

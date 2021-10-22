import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {ActivatedRoute, Router} from '@angular/router';
import {MatSort} from '@angular/material/sort';
import {GlobalServices} from '../../../shared/services/global.services';
import {environment} from '../../../../environments/environment';
import { saveAs } from 'file-saver';

declare let alertify: any;

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
interface HistorialRetiros {
  dateRegistro: String;
  monto: String;
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
  totalPagoM = 0;
  totalZelle = 0;
  totalEfectivo = 0;
  totalAbonado = 0;
  efectivoRetiro = 0;
  totalRetiroUser = 0;
  chargerList = [];
  usuarioList = [
    {value: 1, desc: 'Doctora'},
    {value: 2, desc: 'Operadora'}
    ];
  formPayList = [];
  workerList = [];
  show = false;

  displayedRetires: string[] =
    [
      'dateRegistro',
      'nameRetirement',
      'monto'
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

  dataSource1: MatTableDataSource<HistorialRetiros>;
  @ViewChild("PAGINATOR") paginator1: MatPaginator;
  @ViewChild(MatSort) sort1: MatSort;

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
      userName: new FormControl(),
      formPay: new FormControl(),
      workerRetire: new FormControl(),
      amountRetire: new FormControl(),
      nameRetirement: new FormControl(),
      initialDateRetire: new FormControl(),
      finalDateRetire: new FormControl()

    });
  }


  ngOnInit() {
    this.getMethodsPay();
    this.getWorkers();
    this.getSaldo();
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

  searchRetire() {
    const data = {
      workerRetire: this.filters.controls.workerRetire.value,
      initialDate: this.filters.controls.initialDateRetire.value,
      finalDate: this.filters.controls.finalDateRetire.value
    };
    this.globalServices.httpServicesResponse(data, environment.Url + '/depilarte/searchRetirement').subscribe( res => {
      console.log(res.resultList);  
      const position = res.resultList.length - 1;
        this.totalRetiroUser = res.resultList[position].totalRetirado;
        this.efectivoRetiro = res.resultList[position].saldoRestante;
        res.resultList.pop();
        this.dataSource1 = new MatTableDataSource(res.resultList);
        this.dataSource1.paginator = this.paginator1;
        this.dataSource1.sort = this.sort1;
      }
    )
  }

  saveRetire() {
    const data = {
      workerRetire: this.filters.controls.workerRetire.value,
      amountRetire: this.filters.controls.amountRetire.value
  
    };
    this.globalServices.httpServicesResponse(data, environment.Url + '/depilarte/saveRetirement').subscribe( res => {
      if(res.type==='error'){
        alertify.error('Error al registrar');
      }else{
        alertify.success('Guardado retiros con exito');
        this.filters.controls.workerRetire.reset();
        this.filters.controls.amountRetire.reset();
      }
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

  getSaldo(){
    this.globalServices.httpServicesResponse(null,
      environment.Url + '/global/getSaldo').subscribe( response => {
        if (response.type === 'success') {
          console.log(response);
        }
      },
      console.error);
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

  boton() {
    this.show = true;
  }
  cancelar() {
    this.show = false;
  }
}

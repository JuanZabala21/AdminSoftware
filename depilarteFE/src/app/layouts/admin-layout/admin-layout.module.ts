import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { AdminLayoutRoutes } from './admin-layout.routing';

import { DashboardComponent }       from '../../pages/Inicio/dashboard.component';
import { TableComponent }           from '../../pages/various/table/table.component';
import { TypographyComponent }      from '../../pages/various/typography/typography.component';
import { IconsComponent }           from '../../pages/various/icons/icons.component';
import { MapsComponent }            from '../../pages/various/maps/maps.component';
import { NotificationsComponent }   from '../../pages/various/notifications/notifications.component';
import { UpgradeComponent }         from '../../pages/various/upgrade/upgrade.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { OperadoraComponent } from 'app/pages/registrar/operadorRegistro/operadora.component';
import { TratamientoRegistrarComponent } from 'app/pages/registrar/tratamientoRegistrar/tratamientoRegistrar.component';
import { HistorialDocComponent} from '../../pages/historial/doctoraHistorial/historialDoc.component';
import { TratamientoComponent} from '../../pages/productos/tratamiento/tratamiento.component';
import { InventarioComponent} from '../../pages/productos/inventario/inventario.component';
import { UsuarioRegistroComponent } from '../../pages/registrar/usuario-registro/usuario-registro.component';
import { EmpleadoHistorialComponent } from '../../pages/historial/empleado-historial/empleado-historial.component';
import { RegistrarProductoComponent } from '../../pages/registrar/registrar-producto/registrar-producto.component';

import {MatTableModule} from '@angular/material/table';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSortModule} from '@angular/material/sort';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatCardModule} from '@angular/material/card';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule, MatOptionModule} from '@angular/material/core';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';

import {MatButtonModule} from '@angular/material/button';


@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    NgbModule,
    MatTableModule,
    MatFormFieldModule,
    MatSortModule,
    MatPaginatorModule,
    ReactiveFormsModule,
    MatCardModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatInputModule,
    MatOptionModule,
    MatSelectModule,
    MatButtonModule
  ],
  declarations: [
    DashboardComponent,
    TableComponent,
    HistorialDocComponent,
    UpgradeComponent,
    TratamientoComponent,
    InventarioComponent,
    TypographyComponent,
    IconsComponent,
    MapsComponent,
    NotificationsComponent,
    OperadoraComponent,
    TratamientoRegistrarComponent,
    UsuarioRegistroComponent,
    EmpleadoHistorialComponent,
    RegistrarProductoComponent
  ]
})

export class AdminLayoutModule {}

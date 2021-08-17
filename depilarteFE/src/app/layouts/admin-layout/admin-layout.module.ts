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
import { DoctoraComponent } from 'app/pages/registrar/doctoraRegistro/doctora.component';
import {HistorialDocComponent} from '../../pages/historial/doctoraHistorial/historialDoc.component';
import {MatTableModule} from '@angular/material/table';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSortModule} from '@angular/material/sort';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatCardModule} from '@angular/material/card';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule, MatOptionModule} from '@angular/material/core';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';

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
    MatSelectModule
  ],
  declarations: [
    DashboardComponent,
    DoctoraComponent,
    TableComponent,
    HistorialDocComponent,
    UpgradeComponent,
    TypographyComponent,
    IconsComponent,
    MapsComponent,
    NotificationsComponent,
    OperadoraComponent
  ]
})

export class AdminLayoutModule {}

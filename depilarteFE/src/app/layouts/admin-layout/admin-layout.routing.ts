import { Routes } from '@angular/router';
import { OperadoraComponent } from 'app/pages/registrar/operadorRegistro/operadora.component';
import { DoctoraComponent } from 'app/pages/registrar/doctoraRegistro/doctora.component';
import { DashboardComponent } from '../../pages/Inicio/dashboard.component';
import { TableComponent } from '../../pages/various/table/table.component';
import { TypographyComponent } from '../../pages/various/typography/typography.component';
import { IconsComponent } from '../../pages/various/icons/icons.component';
import { MapsComponent } from '../../pages/various/maps/maps.component';
import { NotificationsComponent } from '../../pages/various/notifications/notifications.component';
import { UpgradeComponent } from '../../pages/various/upgrade/upgrade.component';
import {HistorialDocComponent} from '../../pages/historial/doctoraHistorial/historialDoc.component';

export const AdminLayoutRoutes: Routes = [
    //{ path: 'Inicio',      component: DashboardComponent },
    { path: 'table',          component: TableComponent },
    { path: 'operadora',      component: OperadoraComponent},
    { path: 'doctora',        component: DoctoraComponent},
    { path: 'historial',      component: HistorialDocComponent}
];

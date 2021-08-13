import { Routes } from '@angular/router';
import { operadoraComponent } from 'app/pages/operadora/operadora.component';
import { DoctoraComponent } from 'app/pages/doctora/doctora.component';
import { DashboardComponent } from '../../pages/dashboard/dashboard.component';
import { TableComponent } from '../../pages/table/table.component';
import { TypographyComponent } from '../../pages/typography/typography.component';
import { IconsComponent } from '../../pages/icons/icons.component';
import { MapsComponent } from '../../pages/maps/maps.component';
import { NotificationsComponent } from '../../pages/notifications/notifications.component';
import { UpgradeComponent } from '../../pages/upgrade/upgrade.component';
import {HistorialComponent} from '../../pages/historial/historial.component';

export const AdminLayoutRoutes: Routes = [
    //{ path: 'dashboard',      component: DashboardComponent },
    { path: 'table',          component: TableComponent },
    { path: 'operadora',      component: operadoraComponent},
    { path: 'doctora',        component: DoctoraComponent},
    { path: 'historial',      component: HistorialComponent}
];

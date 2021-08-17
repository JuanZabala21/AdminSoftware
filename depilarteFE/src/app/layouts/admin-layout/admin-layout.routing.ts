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
import {InventarioComponent} from '../../pages/productos/inventario/inventario.component';
import {TratamientoComponent} from '../../pages/productos/tratamiento/tratamiento.component';
import {HistorialOpeComponent} from '../../pages/historial/operadoraHistorial/historialOpe.component';

export const AdminLayoutRoutes: Routes = [
    //{ path: 'Inicio',      component: DashboardComponent },
    { path: 'operadora',              component: OperadoraComponent},
    { path: 'doctora',                component: DoctoraComponent},
    { path: 'historial-doctora',      component: HistorialDocComponent},
    { path: 'historial-operadora',    component: HistorialOpeComponent},
    { path: 'tratamiento',             component: TratamientoComponent},
    { path: 'inventario',             component: InventarioComponent},

];

import { Routes } from '@angular/router';
import { OperadoraComponent } from 'app/pages/registrar/operadorRegistro/operadora.component';
import {HistorialDocComponent} from '../../pages/historial/doctoraHistorial/historialDoc.component';
import {InventarioComponent} from '../../pages/productos/inventario/inventario.component';
import {TratamientoComponent} from '../../pages/productos/tratamiento/tratamiento.component';
import {TratamientoRegistrarComponent} from '../../pages/registrar/tratamientoRegistrar/tratamientoRegistrar.component';

export const AdminLayoutRoutes: Routes = [
    { path: 'registrar-paciente',     component: OperadoraComponent},
    { path: 'historial',               component: HistorialDocComponent},
    { path: 'tratamiento',             component: TratamientoComponent},
    { path: 'inventario',              component: InventarioComponent},
    { path: 'registrar-tratamiento',   component: TratamientoRegistrarComponent},
];

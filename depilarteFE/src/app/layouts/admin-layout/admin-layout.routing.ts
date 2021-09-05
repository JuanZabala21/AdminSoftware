import { Routes } from '@angular/router';
import { OperadoraComponent } from 'app/pages/registrar/operadorRegistro/operadora.component';
import {HistorialDocComponent} from '../../pages/historial/doctoraHistorial/historialDoc.component';
import {InventarioComponent} from '../../pages/productos/inventario/inventario.component';
import {TratamientoComponent} from '../../pages/productos/tratamiento/tratamiento.component';
import {TratamientoRegistrarComponent} from '../../pages/registrar/tratamientoRegistrar/tratamientoRegistrar.component';
import { UsuarioRegistroComponent } from '../../pages/registrar/usuario-registro/usuario-registro.component';
import { EmpleadoHistorialComponent } from '../../pages/historial/empleado-historial/empleado-historial.component';
import { RegistrarProductoComponent } from '../../pages/registrar/registrar-producto/registrar-producto.component';
import {DashboardComponent} from './../../pages/Inicio/dashboard.component'

export const AdminLayoutRoutes: Routes = [
    { path: 'registrar-paciente',     component: OperadoraComponent},
    { path: 'historialDoc',               component: HistorialDocComponent},
    { path: 'tratamiento',             component: TratamientoComponent},
    { path: 'inventario',              component: InventarioComponent},
    { path: 'registrar-tratamiento',   component: TratamientoRegistrarComponent},
    { path: 'registrar-usuario',   component: UsuarioRegistroComponent},
    { path: 'historial-empleado',   component: EmpleadoHistorialComponent},
    { path: 'registrar-producto',   component: RegistrarProductoComponent},
    { path: 'Inicio',               component: DashboardComponent}

];

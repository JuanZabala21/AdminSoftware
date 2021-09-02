import { Component, OnInit } from '@angular/core';


export interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}

export const REGISTER: RouteInfo[] = [
    { path: '/registrar-paciente',        title: 'Pacientes',                   icon:'nc-single-02',  class: '' },
    { path: '/registrar-usuario',         title: 'Empleados',                    icon:'nc-badge',  class: '' },
    { path: '/registrar-tratamiento',     title: 'Tratamiento',              icon:'nc-ambulance',  class: '' },
    { path: '/registrar-producto',        title: 'Productos',                   icon:'nc-single-copy-04',  class: '' }
];

export const HISTORIAL: RouteInfo[] = [
  { path: '/historialDoc',         title: 'Pacientes',           icon:'nc-single-02',    class: '' },
  { path: '/historial-empleado',   title: 'Empleados',           icon:'nc-badge',    class: '' }
];

export const PRODUCTS: RouteInfo[] = [
  { path: '/tratamiento',         title: 'Tratamientos',      icon:'nc-ambulance',    class: '' },
  { path: '/inventario',          title: 'Productos',         icon:'nc-single-copy-04',    class: '' }
];


@Component({
    moduleId: module.id,
    selector: 'sidebar-cmp',
    templateUrl: 'sidebar.component.html',
})

export class SidebarComponent implements OnInit {
    public menuItems: any[];
    public menuItems2: any[];
    public menuItems3: any[];
    ngOnInit() {
        this.menuItems = REGISTER.filter(menuItem => menuItem);
       this.menuItems2 = HISTORIAL.filter(menuItem2 => menuItem2);
       this.menuItems3 = PRODUCTS.filter(menuItem3 => menuItem3);

    }
}

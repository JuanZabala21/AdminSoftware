import { Component, OnInit } from '@angular/core';


export interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}

export const REGISTER: RouteInfo[] = [
    { path: '/operadora',     title: 'Operadora',                    icon:'nc-single-02',  class: '' },
    { path: '/doctora',          title: 'Doctora',                       icon:'nc-single-02',  class: '' },
];

export const HISTORIAL: RouteInfo[] = [
  { path: '/historial-doctora',         title: 'Doctora',        icon:'nc-tile-56',    class: '' },
  { path: '/historial-operadora',         title: 'Operadora',        icon:'nc-tile-56',    class: '' }
];

export const PRODUCTS: RouteInfo[] = [
  { path: '/tratamiento',         title: 'Tratamiento',        icon:'nc-tile-56',    class: '' },
  { path: '/inventario',         title: 'Inventario',        icon:'nc-tile-56',    class: '' }
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

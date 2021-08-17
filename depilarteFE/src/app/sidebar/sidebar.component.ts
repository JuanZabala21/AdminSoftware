import { Component, OnInit } from '@angular/core';


export interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}

export const ROUTES: RouteInfo[] = [
    //{ path: '/Inicio',     title: 'Dashboard',         icon:'nc-bank',       class: '' },
    //{ path: '/icons',         title: 'Icons',             icon:'nc-diamond',    class: '' },
   // { path: '/maps',          title: 'Maps',              icon:'nc-pin-3',      class: '' },
    //{ path: '/notifications', title: 'Notifications',     icon:'nc-bell-55',    class: '' },
  //{ path: '/typography',    title: 'Typography',        icon:'nc-caps-small', class: '' },
  //{ path: '/upgrade',       title: 'Upgrade to PRO',    icon:'nc-spaceship',  class: 'active-pro' },



    { path: '/operadora',     title: 'Operadora',                    icon:'nc-single-02',  class: '' },
    { path: '/doctora',          title: 'Doctora',                       icon:'nc-single-02',  class: '' },

];

export const ROUTES2: RouteInfo[] = [
  { path: '/historial',         title: 'Doctora',        icon:'nc-tile-56',    class: '' },
  { path: '/table',         title: 'Inventario',                    icon:'nc-tile-56',    class: '' },
];

export const ROUTES3: RouteInfo[] = [
  { path: '/table',         title: 'Inventario',                    icon:'nc-tile-56',    class: '' },
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
        this.menuItems = ROUTES.filter(menuItem => menuItem);
       this.menuItems2 = ROUTES2.filter(menuItem2 => menuItem2);
       this.menuItems3 = ROUTES3.filter(menuItem3 => menuItem3);
    }
}

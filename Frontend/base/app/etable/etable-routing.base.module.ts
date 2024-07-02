import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CanDeactivateGuard } from '@baseapp/auth.can-deactivate-guard.service';

import { EtableListComponent } from '@app/etable/etable/etable-list/etable-list.component';
import { EtableDetailComponent } from '@app/etable/etable/etable-detail/etable-detail.component';

export const routes: Routes = [

{
     path: 'etablelist',
     component: EtableListComponent,
     canDeactivate: [ CanDeactivateGuard ],
     data: {
     	label: "ETABLE_LIST",
        breadcrumb: "ETABLE_LIST",
        roles : [					"all"
				]
     }
},
{
     path: 'etabledetail',
     component: EtableDetailComponent,
     canDeactivate: [ CanDeactivateGuard ],
     data: {
     	label: "ETABLE_DETAIL",
        breadcrumb: "ETABLE_DETAIL",
        roles : [					"all"
				]
     }
}
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class EtableBaseRoutingModule
{
}

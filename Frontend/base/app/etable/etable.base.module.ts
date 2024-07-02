import { NgModule } from '@angular/core';
import { BsModalService } from 'ngx-bootstrap/modal';
import { SharedModule } from '@app/shared/shared.module';
import { WidgetsBaseModule } from '@libbase/widgets.base.module';
import { ExportsModule } from '@app/exports/exports.module';
import { EtableListComponent } from '@app/etable/etable/etable-list/etable-list.component';
import { EtableDetailComponent } from '@app/etable/etable/etable-detail/etable-detail.component';
import { CanDeactivateGuard } from '@baseapp/auth.can-deactivate-guard.service';

@NgModule({
  declarations: [
    EtableListComponent,
    EtableDetailComponent
  ],
  imports: [
    SharedModule,
    WidgetsBaseModule,
    ExportsModule,
  ],
  exports: [
    SharedModule,
	WidgetsBaseModule,
    EtableListComponent,
    EtableDetailComponent
  ],
  providers: [
  	BsModalService,
	CanDeactivateGuard
  ],
  
})
export class EtableBaseModule { }
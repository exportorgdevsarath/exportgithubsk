import { NgModule } from '@angular/core';
import { BsModalService } from 'ngx-bootstrap/modal';
import { SharedModule } from '@app/shared/shared.module';
import { WidgetsBaseModule } from '@libbase/widgets.base.module';
import { ExportsModule } from '@app/exports/exports.module';
import { ApplicationUserListComponent } from '@app/application-user/application-user/application-user-list/application-user-list.component';
import { ApplicationUserDetailComponent } from '@app/application-user/application-user/application-user-detail/application-user-detail.component';
import { CanDeactivateGuard } from '@baseapp/auth.can-deactivate-guard.service';

@NgModule({
  declarations: [
    ApplicationUserListComponent,
    ApplicationUserDetailComponent
  ],
  imports: [
    SharedModule,
    WidgetsBaseModule,
    ExportsModule,
  ],
  exports: [
    SharedModule,
	WidgetsBaseModule,
    ApplicationUserListComponent,
    ApplicationUserDetailComponent
  ],
  providers: [
  	BsModalService,
	CanDeactivateGuard
  ],
  
})
export class ApplicationUserBaseModule { }
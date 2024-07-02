import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EtableRoutingModule } from './etable-routing.module';
import { EtableBaseModule } from '@baseapp/etable/etable.base.module';
@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule,
    EtableBaseModule,
    EtableRoutingModule
    
  ],
  exports: [
      EtableBaseModule,
  ]

})
export class EtableModule  { }
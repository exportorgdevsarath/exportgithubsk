import { Component, OnInit,inject } from '@angular/core';
import { EtableListBaseComponent } from '@baseapp/etable/etable/etable-list/etable-list.base.component';
import { EtableService } from '@baseapp/etable/etable/etable.service';


@Component({
  selector: 'app-etable-list',
  templateUrl: '../../../../../base/app/etable/etable/etable-list/etable-list.component.html',
  styleUrls: ['./etable-list.scss']
})
export class EtableListComponent extends EtableListBaseComponent implements OnInit {
 
	
  ngAfterViewInit(): void {
    this.onAfterViewInit()
  }

  ngOnInit(): void {
    super.onInit();
  }
 
}
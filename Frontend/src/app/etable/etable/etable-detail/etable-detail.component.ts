import { Component, OnInit,inject } from '@angular/core';
import { EtableDetailBaseComponent } from '@baseapp/etable/etable/etable-detail/etable-detail.base.component';
import { EtableService } from '@baseapp/etable/etable/etable.service';


@Component({
  selector: 'app-etable-detail',
  templateUrl: '../../../../../base/app/etable/etable/etable-detail/etable-detail.component.html',
  styleUrls: ['./etable-detail.scss']
})
export class EtableDetailComponent extends EtableDetailBaseComponent implements OnInit {
 
	
  ngAfterViewInit(): void {
    this.onAfterViewInit()
  }

  ngOnInit(): void {
    super.onInit();
  }
 
}
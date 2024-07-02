package com.vanenburgdemo.exapp.service;

import com.vs.rappit.base.acl.IPerimeterManager;
import com.vanenburgdemo.exapp.base.service.EtableBaseService;
import com.vanenburgdemo.exapp.model.Etable;
import com.vanenburgdemo.exapp.service.EtablePerimeterImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service("Etable")
public class EtableService extends EtableBaseService<Etable> implements IEtableService<Etable>{

		@Autowired
		private  EtablePerimeterImpl  etablePerimeterImpl;

		public EtableService(ChangelogService changelogService) {
		super(Etable.class);	
		setChangelogService(changelogService); 
		
	}
	
}
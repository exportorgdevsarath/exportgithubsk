package com.vanenburgdemo.exapp.dataexport.service;

import com.vs.rappit.base.logger.Logger;
import com.vs.rappit.base.logger.LoggerFactory;
import org.springframework.stereotype.Service;
import com.vs.rappit.dataexport.base.service.RappitExportBaseService;
import com.vs.rappit.dataexport.model.RappitExport;

@Service("rappitExportService")
public class RappitExportService extends RappitExportBaseService<RappitExport>
		implements IRappitExportService<RappitExport> {
		
	private Logger LOGGER = LoggerFactory.getLogger(RappitExportService.class);
	
	
	public RappitExportService() {
		super(RappitExport.class);
	}
	
}

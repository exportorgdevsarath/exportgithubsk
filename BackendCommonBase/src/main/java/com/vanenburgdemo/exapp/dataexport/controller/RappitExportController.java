package com.vanenburgdemo.exapp.dataexport.controller;

import com.vs.rappit.base.logger.Logger;
import com.vs.rappit.base.logger.LoggerFactory;
import com.vs.rappit.dataexport.base.controller.RappitExportBaseController;
import com.vs.rappit.dataexport.base.service.IRappitExportBaseService;
import com.vs.rappit.dataexport.model.RappitExport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "rest/rappitexports/", produces = "application/json")
public class RappitExportController extends RappitExportBaseController<IRappitExportBaseService<RappitExport>, RappitExport> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RappitExportController.class.getName());
	
	public RappitExportController(IRappitExportBaseService<RappitExport> baseBusinessLogic) {
		super(baseBusinessLogic);
	}
	
}

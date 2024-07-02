package com.vanenburgdemo.exapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import com.vs.rappit.base.logger.Logger;
import com.vs.rappit.base.logger.LoggerFactory;
import org.springframework.http.ResponseEntity;
import com.vs.rappit.base.factory.InstanceFactory;
import com.vanenburgdemo.exapp.base.controller.EtableBaseController;
import com.vanenburgdemo.exapp.service.IEtableService;
import com.vanenburgdemo.exapp.service.EtableService;
import com.vanenburgdemo.exapp.model.Etable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "rest/etables/", produces = "application/json")
public class EtableController extends EtableBaseController<IEtableService<Etable>, Etable> {
	private static final Logger LOGGER = LoggerFactory.getLogger(EtableController.class.getName());
	public EtableController(EtableService etableService) {
		super(etableService);
	}
}

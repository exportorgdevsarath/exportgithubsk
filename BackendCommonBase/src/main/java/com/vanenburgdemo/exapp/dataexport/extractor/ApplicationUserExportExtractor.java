package com.vanenburgdemo.exapp.dataexport.extractor;

import com.vs.rappit.base.logger.Logger;
import com.vs.rappit.base.logger.LoggerFactory;
import com.vanenburgdemo.exapp.base.model.ApplicationUserAnalyticalBase;
import com.vanenburgdemo.exapp.base.dataexport.extractor.ApplicationUserBaseExportExtractor;
import com.vanenburgdemo.exapp.dataexport.extractor.ApplicationUserAnalyticalExtractorService;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Scope;

@Service
@Scope(value = "prototype")
public class ApplicationUserExportExtractor extends ApplicationUserBaseExportExtractor<ApplicationUserAnalyticalExtractorService, ApplicationUserAnalyticalBase> {

	private Logger LOGGER = LoggerFactory.getLogger(ApplicationUserExportExtractor.class);
	
	public ApplicationUserExportExtractor(ApplicationUserAnalyticalExtractorService logic) {
		super(true, logic);
	}

	
}

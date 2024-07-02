package com.vanenburgdemo.exapp.dataexport.extractor;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.vs.rappit.base.logger.Logger;
import com.vs.rappit.base.logger.LoggerFactory;
import com.vanenburgdemo.exapp.base.model.ApplicationUserAnalyticalBase;
import com.vanenburgdemo.exapp.base.dataexport.extractor.ApplicationUserBaseAnalyticalExtractorService;
import com.vs.rappit.base.listener.BaseApplicationConfiguration;

@Component
@Scope(value = "prototype")
public class ApplicationUserAnalyticalExtractorService extends ApplicationUserBaseAnalyticalExtractorService<ApplicationUserAnalyticalBase> {
	private Logger LOGGER = LoggerFactory.getLogger(ApplicationUserAnalyticalExtractorService.class);
	
	public ApplicationUserAnalyticalExtractorService(BaseApplicationConfiguration baseApplicationConfiguration) {
		super(ApplicationUserAnalyticalBase.class, baseApplicationConfiguration);
	}
}

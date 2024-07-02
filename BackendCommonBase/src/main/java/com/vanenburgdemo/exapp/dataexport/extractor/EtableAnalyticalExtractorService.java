package com.vanenburgdemo.exapp.dataexport.extractor;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.vs.rappit.base.logger.Logger;
import com.vs.rappit.base.logger.LoggerFactory;
import com.vanenburgdemo.exapp.base.model.EtableAnalyticalBase;
import com.vanenburgdemo.exapp.base.dataexport.extractor.EtableBaseAnalyticalExtractorService;
import com.vs.rappit.base.listener.BaseApplicationConfiguration;

@Component
@Scope(value = "prototype")
public class EtableAnalyticalExtractorService extends EtableBaseAnalyticalExtractorService<EtableAnalyticalBase> {
	private Logger LOGGER = LoggerFactory.getLogger(EtableAnalyticalExtractorService.class);
	
	public EtableAnalyticalExtractorService(BaseApplicationConfiguration baseApplicationConfiguration) {
		super(EtableAnalyticalBase.class, baseApplicationConfiguration);
	}
}

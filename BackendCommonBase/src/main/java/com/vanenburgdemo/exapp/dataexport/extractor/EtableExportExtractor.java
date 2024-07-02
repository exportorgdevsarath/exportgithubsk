package com.vanenburgdemo.exapp.dataexport.extractor;

import com.vs.rappit.base.logger.Logger;
import com.vs.rappit.base.logger.LoggerFactory;
import com.vanenburgdemo.exapp.base.model.EtableAnalyticalBase;
import com.vanenburgdemo.exapp.base.dataexport.extractor.EtableBaseExportExtractor;
import com.vanenburgdemo.exapp.dataexport.extractor.EtableAnalyticalExtractorService;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Scope;

@Service
@Scope(value = "prototype")
public class EtableExportExtractor extends EtableBaseExportExtractor<EtableAnalyticalExtractorService, EtableAnalyticalBase> {

	private Logger LOGGER = LoggerFactory.getLogger(EtableExportExtractor.class);
	
	public EtableExportExtractor(EtableAnalyticalExtractorService logic) {
		super(true, logic);
	}

	
}

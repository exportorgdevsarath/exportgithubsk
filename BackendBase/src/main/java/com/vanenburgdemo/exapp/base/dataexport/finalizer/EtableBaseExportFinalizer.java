package com.vanenburgdemo.exapp.base.dataexport.finalizer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.vanenburgdemo.exapp.base.model.ApplicationUserBase;
import com.vanenburgdemo.exapp.base.service.ApplicationUserBaseService;
import com.vs.rappit.base.dal.Filter;
import com.vs.rappit.base.dal.SimpleFilter;
import com.vs.rappit.base.mail.model.EmailAddress;
import com.vs.rappit.base.mail.model.EmailDetails;
import com.vs.rappit.dataexport.handler.ExportFinalizer;
import com.vs.rappit.dataexport.model.RappitExport;

public class EtableBaseExportFinalizer extends ExportFinalizer<RappitExport> {
	
	private ApplicationUserBaseService  applicationUserBaseService;
	public EtableBaseExportFinalizer(ApplicationUserBaseService applicationUserBaseService, boolean isChunk) {
		super(isChunk);
		this.applicationUserBaseService = applicationUserBaseService;
	}

	@Override
	public void resolveCustomMailPlaceholders(Map<String, String> placeholderMap) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onbeforeSendingmail(EmailDetails emailDetails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAfterSendingmail(EmailDetails emailDetails) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Set<EmailAddress> resolveRoles(String[] roles) {
		Set<EmailAddress> list = new HashSet<>();
		for (String role : roles) {
			List<EmailAddress> emailsByRole = getUserEmailsByRole(role);
			list.addAll(emailsByRole);
		}
		return list;
	}

	private List<EmailAddress> getUserEmailsByRole(String role) {
		List<EmailAddress> emailList = new ArrayList<>();
		List<Filter> filters = new ArrayList<>();
		Filter filter = new SimpleFilter(role, true);
		filters.add(filter);
		List<ApplicationUserBase> users = applicationUserBaseService.getAll(filters);
		for (ApplicationUserBase user : users) {
			EmailAddress emailAddress = new EmailAddress(user.getEmail());
			emailList.add(emailAddress);
		}
		return emailList;
	}


}

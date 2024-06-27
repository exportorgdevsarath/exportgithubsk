package com.vanenburgdemo.exapp.base.service;

import com.vs.rappit.base.authentication.IAppUserPrivilegeBL;
import com.vanenburgdemo.exapp.base.model.ApplicationUserBase;
import com.vs.rappit.base.mail.model.EmailAddress;
import java.util.List;
import com.vs.rappit.base.model.wrapper.UserPrivilegePerimeter;
import java.util.Map;


public interface IApplicationUserBaseService<T extends ApplicationUserBase> extends IAppUserPrivilegeBL<T> {
	public T getByEmail(String email);


	public List<EmailAddress> getUsersByRole(UserPrivilegePerimeter rolePerimeterInfo, Integer page, Integer pageSize);

	public Map<String,String> getAllRolesMap();
}
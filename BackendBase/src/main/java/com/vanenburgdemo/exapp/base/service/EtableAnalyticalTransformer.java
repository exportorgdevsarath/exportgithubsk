package com.vanenburgdemo.exapp.base.service;

import com.vs.rappit.base.model.IModelTransformer;
import com.vanenburgdemo.exapp.base.model.EtableBase;
import com.vanenburgdemo.exapp.base.model.EtableAnalyticalBase;
import com.vs.rappit.base.util.Configuration;
import java.util.stream.Collectors;

public class EtableAnalyticalTransformer<T extends EtableBase, M extends EtableAnalyticalBase>
		implements IModelTransformer<T, M> {
	private static final String SEPARATOR = "#@$%!*&";
	@Override
	public M writeTo(T model) {
		EtableAnalyticalBase etableAnalyticalBase = new EtableAnalyticalBase();
			etableAnalyticalBase.setOne(model.getOne());
	etableAnalyticalBase.setThree(model.getThree());
		etableAnalyticalBase.setSid(model.getSid());
		return (M) etableAnalyticalBase;
	}

	@Override
	public Object readFrom(M data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<T> getSourceClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<M> getTargetClass() {
		// TODO Auto-generated method stub
		return null;
	}

}

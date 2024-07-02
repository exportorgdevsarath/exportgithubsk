package com.vanenburgdemo.exapp.base.model;
import com.vs.rappit.base.annotations.Table;
import com.vs.rappit.base.model.BaseAnalyticalModel;


@Table(name="Etable")
public class EtableAnalyticalBase extends BaseAnalyticalModel {
	private static final long serialVersionUID = -1653584662510644834L;
		private Long one;
	private String three;

	public void setOne(Long one) {
		this.one = one;
	}

	public Long getOne() {
		return one;
	}

	public void setThree(String three) {
		this.three = three;
	}

	public String getThree() {
		return three;
	}


}
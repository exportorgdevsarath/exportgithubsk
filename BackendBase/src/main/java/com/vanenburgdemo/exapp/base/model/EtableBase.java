package com.vanenburgdemo.exapp.base.model;
import com.vs.rappit.base.model.BaseModel;
import com.vs.rappit.base.annotations.Table;
import com.vs.rappit.base.annotations.Searchable;


@Table(name="Etable", keys={"sid"})
public class EtableBase extends BaseModel {

	@Searchable(index = true)
	private Long one;
	@Searchable(index = true)
	private String two;
	@Searchable(index = true)
	private String three;

	public void setOne(Long one) {
		this.one = one;
	}

	public Long getOne() {
		return one;
	}

	public void setTwo(String two) {
		this.two = two;
	}

	public String getTwo() {
		return two;
	}

	public void setThree(String three) {
		this.three = three;
	}

	public String getThree() {
		return three;
	}



}
package com.po;

import java.io.Serializable;
import java.util.Date;

public class IAttachment implements Serializable{
	private static final long serialVersionUID = -5766950636572489336L;
	private Integer total_num;            //C端CFBS系统每个城市市进件量
	private String province;              //经销商所在省
	private String city;    			  //经销商所在市

	public Integer getTotal_num() {
		return total_num;
	}

	public void setTotal_num(Integer total_num) {
		this.total_num = total_num;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "IAttachment [total_num=" + total_num + ", province=" + province + ", city="
				+ city + "]";
	}
	
}

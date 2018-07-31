package com.AlMark.bean;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "logData")
@XmlAccessorType(XmlAccessType.FIELD)
public class LogData {

	@XmlElement(name = "data")
	private List<String> data ;

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}
	

	@Override
	public String toString() {
		return super.toString();
	}
}

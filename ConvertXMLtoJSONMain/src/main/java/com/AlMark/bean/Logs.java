package com.AlMark.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "logs")
@XmlAccessorType(XmlAccessType.FIELD)
public class Logs {
	
	@XmlElement(name = "log")
	private List<Log> logs;

	public List<Log> getLogs() {
		return logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	

}

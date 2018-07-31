package com.AlMark.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "log")
@XmlAccessorType(XmlAccessType.FIELD)
public class Log {

	
	private String nameWell;
	private String nameWellbore;
	private String name;
	private boolean objectGrowing;
	private int dataRowCount;
	private String serviceCompany;
	private String indexType;
	private int stepIncrement;
	private String startDateTimeIndex;
	private String endDateTimeIndex;
	private String direction;
	private String indexCurve;
	private int nullValue;
	@XmlElement(name = "logCurveInfo")
	private List<LogCurveInfo> logCurveInfo ;
	@XmlElement(name = "logData")
	private List<LogData> logData ;

	

	public String getNameWell() {
		return nameWell;
	}
	public void setNameWell(String nameWell) {
		this.nameWell = nameWell;
	}
	public String getNameWellbore() {
		return nameWellbore;
	}
	public void setNameWellbore(String nameWellbore) {
		this.nameWellbore = nameWellbore;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isObjectGrowing() {
		return objectGrowing;
	}
	public void setObjectGrowing(boolean objectGrowing) {
		this.objectGrowing = objectGrowing;
	}
	public int getDataRowCount() {
		return dataRowCount;
	}
	public void setDataRowCount(int dataRowCount) {
		this.dataRowCount = dataRowCount;
	}
	public String getServiceCompany() {
		return serviceCompany;
	}
	public void setServiceCompany(String serviceCompany) {
		this.serviceCompany = serviceCompany;
	}
	public String getIndexType() {
		return indexType;
	}
	public void setIndexType(String indexType) {
		this.indexType = indexType;
	}
	public int getStepIncrement() {
		return stepIncrement;
	}
	public void setStepIncrement(int stepIncrement) {
		this.stepIncrement = stepIncrement;
	}
	public String getStartDateTimeIndex() {
		return startDateTimeIndex;
	}
	public void setStartDateTimeIndex(String startDateTimeIndex) {
		this.startDateTimeIndex = startDateTimeIndex;
	}
	public String getEndDateTimeIndex() {
		return endDateTimeIndex;
	}
	public void setEndDateTimeIndex(String endDateTimeIndex) {
		this.endDateTimeIndex = endDateTimeIndex;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getIndexCurve() {
		return indexCurve;
	}
	public void setIndexCurve(String indexCurve) {
		this.indexCurve = indexCurve;
	}
	public int getNullValue() {
		return nullValue;
	}
	public void setNullValue(int nullValue) {
		this.nullValue = nullValue;
	}
	public List<LogCurveInfo> getLogCurveInfos() {
		return logCurveInfo;
	}
	public void setLogCurveInfos(List<LogCurveInfo> logCurveInfos) {
		this.logCurveInfo = logCurveInfos;
	}
	public List<LogCurveInfo> getLogCurveInfo() {
		return logCurveInfo;
	}
	public void setLogCurveInfo(List<LogCurveInfo> logCurveInfo) {
		this.logCurveInfo = logCurveInfo;
	}
	public List<LogData> getLogData() {
		return logData;
	}
	public void setLogData(List<LogData> logData) {
		this.logData = logData;
	}


	@Override
	public String toString() {
		return super.toString();
	}
	
}

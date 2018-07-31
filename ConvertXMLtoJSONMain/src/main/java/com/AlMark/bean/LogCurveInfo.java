package com.AlMark.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "logCurveInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class LogCurveInfo {
	
	private String mnemonic;
	private String unit;
	private int nullValue;
	private String minDateTimeIndex;
	private String maxDateTimeIndex;
	private int columnIndex;
	private String curveDescription;
	private String typeLogData;
	
	
	public String getMnemonic() {
		return mnemonic;
	}
	public void setMnemonic(String mnemonic) {
		this.mnemonic = mnemonic;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getNullValue() {
		return nullValue;
	}
	public void setNullValue(int nullValue) {
		this.nullValue = nullValue;
	}
	public String getMinDateTimeIndex() {
		return minDateTimeIndex;
	}
	public void setMinDateTimeIndex(String minDateTimeIndex) {
		this.minDateTimeIndex = minDateTimeIndex;
	}
	public String getMaxDateTimeIndex() {
		return maxDateTimeIndex;
	}
	public void setMaxDateTimeIndex(String maxDateTimeIndex) {
		this.maxDateTimeIndex = maxDateTimeIndex;
	}
	public int getColumnIndex() {
		return columnIndex;
	}
	public void setColumnIndex(int columnIndex) {
		this.columnIndex = columnIndex;
	}
	public String getCurveDescription() {
		return curveDescription;
	}
	public void setCurveDescription(String curveDescription) {
		this.curveDescription = curveDescription;
	}
	public String getTypeLogData() {
		return typeLogData;
	}
	public void setTypeLogData(String typeLogData) {
		this.typeLogData = typeLogData;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
}

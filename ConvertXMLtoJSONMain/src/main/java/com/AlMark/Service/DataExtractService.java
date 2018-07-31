package com.AlMark.Service;

import java.util.ArrayList;

import com.AlMark.bean.LogCurveInfo;
import com.AlMark.bean.Logs;

public interface DataExtractService {
	
	public ArrayList<LogCurveInfo> xmlLogCurveInfo(Logs logs);
	public ArrayList<String> xmlLogData(Logs logs);
	public void sortedInsert(ArrayList<String> mnemonic, ArrayList<String> singleArray);
	public void dataExportByMnemonic(Logs logs);
}

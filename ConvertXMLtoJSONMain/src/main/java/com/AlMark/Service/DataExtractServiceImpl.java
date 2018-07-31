package com.AlMark.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.AlMark.bean.Log;
import com.AlMark.bean.LogCurveInfo;
import com.AlMark.bean.LogData;
import com.AlMark.bean.Logs;
import com.AlMark.mongo.MongConnection;
import com.mongodb.BasicDBObject;

public class DataExtractServiceImpl implements DataExtractService{

	public static ArrayList<String> mnemonic = new ArrayList<String>();
	public static ArrayList<String> singleArray = new ArrayList<String>();
	public static ArrayList<Integer> columnIndex = new ArrayList<Integer>();
	public static ArrayList<LogCurveInfo> logCurveDetails = new ArrayList<LogCurveInfo>();
	public static ArrayList<String> logDataDetails = new ArrayList<String>();
	public static String[] splitedString = null;
	public static int id=10000;
	public ArrayList<LogCurveInfo> xmlLogCurveInfo(Logs logs){
		List<Log> temp = logs.getLogs();
		
		for (Log t : temp) {
			List<LogCurveInfo> lCurve = t.getLogCurveInfo();
			for (LogCurveInfo lCurveElement : lCurve) {
				mnemonic.add(lCurveElement.getMnemonic().toString());
				// System.out.println(mnemonic);
				columnIndex.add(lCurveElement.getColumnIndex());
				// System.out.println(columnIndex);
				logCurveDetails.add(lCurveElement);
			}
		}
		return  logCurveDetails;
	}
	
	public  ArrayList<String> xmlLogData(Logs logs){
		List<Log> temp = logs.getLogs();
		xmlLogCurveInfo(logs);
		for (Log t : temp) {
			List<LogData> ldata = t.getLogData();
			for (LogData dat : ldata) {
				List<String> dataString = dat.getData();
				for (String string : dataString) {
					splitedString = string.split(",");
					// System.out.println(Arrays.toString(splitedString));
					for (int j = 0; j < splitedString.length; j++) {
						singleArray.add(splitedString[j]);
						
					}
					logDataDetails.add(string);
					
					//System.out.println(singleArray.get(3));
					//System.out.println(mnemonic.get(3));
					//System.out.println(Arrays.toString(splitedString));
					
				}
				sortedInsert(mnemonic, singleArray);
				singleArray=null;
			}
		}
		return logDataDetails;
	}
	public void sortedInsert(ArrayList<String> mnemonic, ArrayList<String> singleArray){
		Map<String, Object> documentMap = new HashMap<String, Object>();
		int insertLoopNO=(int)singleArray.size()/mnemonic.size();
        int x=0;
        List<BasicDBObject> mainDocuments = new ArrayList<BasicDBObject>();
        
        //System.out.println(" singleArray.size() : "+singleArray.size()+" mnemonic.size() : "+mnemonic.size());
        for(int j=0;j<insertLoopNO;j++){
        	documentMap.put("_id", id+1);
        	for(int k=0;k<mnemonic.size();k++){
        		//System.out.println(" k : "+k+" x : "+x+" insertLoopNO : "+insertLoopNO);
        		documentMap.put(mnemonic.get(k), singleArray.get(x));
        		x+=1;
        	}
        	mainDocuments.add(new BasicDBObject(documentMap));
        	id+=1;
        }
        //MongConnection.mongoDBTotalInsert("test", "testData2",new BasicDBObject(documentMap));
        MongConnection.mongoDBTotalInsert("test", "testData2", mainDocuments);
	}
	
	@SuppressWarnings("resource")
	public void dataExportByMnemonic(Logs logs){
		xmlLogCurveInfo(logs);
		BasicDBObject dbObj = new BasicDBObject();
		for (int i = 0; i < mnemonic.size(); i++) {
			System.out.println(i+" : "+mnemonic.get(i));
		}
		while(true){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your choice by Number");
		int choice=sc.nextInt();
		dbObj.put(mnemonic.get(choice), 0);
		MongConnection.mongoDBParticularExport("test", "testData2", dbObj);
		//MongConnection.mongoDBExport("test", "testData2");
		}
	}
}

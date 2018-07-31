package com.AlMark.ConvertXMLtoJSONMain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.management.MXBean;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.w3c.dom.ls.LSInput;


import com.AlMark.Service.DataExtractServiceImpl;
import com.AlMark.bean.Log;
import com.AlMark.bean.LogCurveInfo;
import com.AlMark.bean.LogData;
import com.AlMark.bean.Logs;
import com.AlMark.mongo.MongConnection;
import com.AlMark.mongo.TestUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.util.JSON;


/**
 * Hello world!
 *
 */
public class App 
{
	
	
	//public static String XML_FILE = "src/main/java/witsmlData/witsmlData.xml";
	public static String XML_FILE = "src/main/java/witsmlData/witsmlData5Sec.xml";
	public static int c=0;
	public static int a=0;
	
	public static void main( String[] args ) throws JAXBException, IOException
    {
    	
    	Logs logs = convertXmltoObject(new FileInputStream(new File(XML_FILE)));
        System.out.println( "Hello World!" );
        //System.out.println(convertObjecttoJSON(logs));
       
       // BasicDBObject dbObj =  (BasicDBObject) JSON.parse(convertObjecttoJSON(logs));
      // MongConnection.mongoDBExport("test", "testData2");
        
        DataExtractServiceImpl dataExtract=new DataExtractServiceImpl();
        /*for (LogCurveInfo logCurveInfo : dataExtract.xmlLogCurveInfo(logs)) {
			//System.out.println(logCurveInfo.getColumnIndex());
			//System.out.println(logCurveInfo.getMnemonic());
		}
        for (String string : dataExtract.xmlLogData(logs)) {
			//System.out.println(string);
			//System.out.println(string);
		}*/
        
        //dataExtract.xmlLogData(logs);
        dataExtract.dataExportByMnemonic(logs);
    }

	public static Logs convertXmltoObject(InputStream in) throws JAXBException{
    	JAXBContext jaxbContext = JAXBContext.newInstance(Logs.class);
    	Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    	return (Logs) unmarshaller.unmarshal(in);
    }
    
    public static String convertObjecttoJSON(Logs logs){
    	GsonBuilder gsonBuilder = new GsonBuilder();
    	gsonBuilder.setPrettyPrinting();
    	gsonBuilder.disableHtmlEscaping();
    	
    	Gson gson = gsonBuilder.create();
    	return 	gson.toJson(logs, Logs.class);
    }

}
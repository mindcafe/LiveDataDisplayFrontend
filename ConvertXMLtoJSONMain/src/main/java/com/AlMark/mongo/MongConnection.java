package com.AlMark.mongo;

import java.awt.List;

import com.AlMark.bean.Logs;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongConnection {

	public static MongoClient mongoDBUtil(){
		
		MongoClient mongoClient=new MongoClient("localhost", 27017);
		return mongoClient;
	}
public static void mongoDBTotalInsert(String dbName,String collName,java.util.List<BasicDBObject> dbObj){
	MongoClient mongoClient = MongConnection.mongoDBUtil();
	DB dB = mongoClient.getDB(dbName);
	DBCollection dbColl = dB.getCollection(collName);
	dbColl.drop();
	dbColl.insert(dbObj);
}	
	public static void mongoDBExport(String dbName,String collName){
		MongoClient mongoClient = MongConnection.mongoDBUtil();
		DB dB = mongoClient.getDB(dbName);
		DBCollection dbCollection=dB.getCollection(collName);
		DBCursor dbCursor = dbCollection.find();
		while(dbCursor.hasNext()){
			
			System.out.println(dbCursor.next());
		}
	}
	
	public static void mongoDBParticularExport(String dbName,String collName, BasicDBObject findDocs){
		MongoClient mongoClient = MongConnection.mongoDBUtil();
		DB dB = mongoClient.getDB(dbName);
		DBCollection dbCollection=dB.getCollection(collName);
		BasicDBObject blankObj=new BasicDBObject();
		DBCursor dbCursor = dbCollection.find(blankObj,findDocs);
		while(dbCursor.hasNext()){
			
			System.out.println(dbCursor.next());
		}
	}
}

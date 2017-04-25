package co.santosh.utils;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoDBJDBC {
	public DB getConnection(){
		DB db = null;
		 try{   
				
	         // To connect to mongodb server
	         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
				
	         // Now connect to your databases
	         db = mongoClient.getDB( "test" );
	         System.out.println("Connect to database successfully");
				
	      }catch(Exception e){
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      }
		 return db;
	}
	
	public void createCollection(DB db){
		try{
			DBCollection coll = db.createCollection("mycol",null);
	        System.out.println("Collection created successfully");
		}
		catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}	
	}
	
	public DBCollection getCollection(DB db){
		DBCollection coll = null;
		try{
			coll = db.getCollection("mycol");
	        System.out.println("Collection mycol selected successfully");
		}
		catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
		return coll;
	}
	
	public void insertDocument(DB db, DBCollection coll){
		try{
			BasicDBObject doc = new BasicDBObject("title", "MongoDB").
		            append("description", "database").
		            append("likes", 100).
		            append("url", "http://www.edureka.com/mongodb/").
		            append("by", "Edureka");
						
			coll.insert(doc);
		    System.out.println("Document inserted successfully");
		}
		catch(Exception e){
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    }
	}
	
	public void reteriveAllDocument(DB db, DBCollection coll){
		try{
			DBCursor cursor = coll.find();
	        int i = 1;
				
	        while (cursor.hasNext()) { 
	           System.out.println("Inserted Document: "+i); 
	           System.out.println(cursor.next()); 
	           i++;
	        }
		}
		catch(Exception e){
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
		
	}
	
	public void updateAllDocument(DB db,DBCollection coll){
		try{
			DBCursor cursor = coll.find();
			
	         while (cursor.hasNext()) { 
	            DBObject updateDocument = cursor.next();
	            updateDocument.put("likes","200");
	            coll.update(updateDocument,updateDocument, true, false); 
	         }
				
	       System.out.println("Document updated successfully");
		}
		catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
	}
	
	public void deleteFirst(DB db,DBCollection coll){
		try{
			DBObject myDoc = coll.findOne();
	         coll.remove(myDoc);
	         System.out.println("First document deleted..");
		}
		catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
	}
	
	public static void main(String args[]){
		MongoDBJDBC mongodbJdbc = new MongoDBJDBC();
		DB db = mongodbJdbc.getConnection();  
		mongodbJdbc.createCollection(db);
		DBCollection coll = mongodbJdbc.getCollection(db);
		//mongodbJdbc.insertDocument(db, coll);
		//mongodbJdbc.reteriveAllDocument(db, coll);
		//mongodbJdbc.updateAllDocument(db, coll);
		//mongodbJdbc.reteriveAllDocument(db, coll);
		mongodbJdbc.deleteFirst(db, coll);
		mongodbJdbc.reteriveAllDocument(db, coll);
	}
}

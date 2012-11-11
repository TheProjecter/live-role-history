package net.mouluso.liverolehistory.storage;

import java.util.ArrayList;

import net.mouluso.liverolehistory.model.Event;
import net.mouluso.liverolehistory.model.History;
import net.mouluso.liverolehistory.storage.constants.StorageConstants;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;

public class DatabaseOperations {
	private Context context;
	private static DatabaseOperations instance;
	
	private DatabaseOperations(Context context){
		this.context = context;
	}
	
	
	public static DatabaseOperations getInstance(Context context){
		if(instance == null){
			instance = new DatabaseOperations(context);
		}else{
			instance.context = context;	
		}
		
		return instance;
	}
	
	
	private DatabaseOpenHelper loadDBHelper(String dbName, int version){
		return new DatabaseOpenHelper(context, dbName, null, version);
	}
	
	
	public void insertHistory(int id, String name, String description, String image){
		DatabaseOpenHelper dbh = loadDBHelper(StorageConstants.DATABASE_NAME, StorageConstants.DATABASE_VERSION);
		SQLiteDatabase db = dbh.getWritableDatabase();
		
		ContentValues cv = new ContentValues();
		cv.put(StorageConstants.ID, id);
		cv.put(StorageConstants.NAME, name);
		cv.put(StorageConstants.DESCRIPTION, description);
		cv.put(StorageConstants.IMAGE, image);
		
		db.insert(StorageConstants.HISTORY_TABLE, null, cv);
		
		db.close();
		dbh.close();
	}
	
	
	public void insertEvent(String description, int historyId,  int order, String question, String answer, int search,
			int latitude, int longitude){
		DatabaseOpenHelper dbh = loadDBHelper(StorageConstants.DATABASE_NAME, StorageConstants.DATABASE_VERSION);
		SQLiteDatabase db = dbh.getWritableDatabase();
		
		ContentValues cv = new ContentValues();
		cv.put(StorageConstants.DESCRIPTION, description);
		cv.put(StorageConstants.HISTORY_ID, historyId);
		cv.put(StorageConstants.ORDER, order);
		cv.put(StorageConstants.LATITUDE, latitude);
		cv.put(StorageConstants.LONGITUDE, longitude);
		cv.put(StorageConstants.SEARCH, search);
		cv.put(StorageConstants.QUESTION, question);
		cv.put(StorageConstants.ANSWER, answer);
		
		
		db.insert(StorageConstants.EVENTS_TABLE, null, cv);
		
		db.close();
		dbh.close();
	}
	
	
	public ArrayList<History> getHistoryList(){
		DatabaseOpenHelper dbh = loadDBHelper(StorageConstants.DATABASE_NAME, StorageConstants.DATABASE_VERSION);
		SQLiteDatabase db = dbh.getReadableDatabase();
		
		Cursor c = db.query(StorageConstants.HISTORY_TABLE, null, null, null, null, null, null);
		
		ArrayList<History> historys = new ArrayList<History>();
		
		if(c.moveToFirst()){
			do{
				int id = c.getInt(c.getColumnIndex(StorageConstants.ID));
				String name = c.getString(c.getColumnIndex(StorageConstants.NAME));
				String description = c.getString(c.getColumnIndex(StorageConstants.DESCRIPTION));
				String image = c.getString(c.getColumnIndex(StorageConstants.IMAGE));
				historys.add(new History(id, name, description, image));
			}while(c.moveToNext());
		}
		
		db.close();
		dbh.close();
		
		return historys;
	}
	
	
	public Event getEvent(int historyId, int order){
		DatabaseOpenHelper dbh = loadDBHelper(StorageConstants.DATABASE_NAME, StorageConstants.DATABASE_VERSION);
		SQLiteDatabase db = dbh.getReadableDatabase();
		
		Cursor c = db.query(StorageConstants.EVENTS_TABLE, null, null, null, null, null, null);
		
		Event e = null;
		
		if(c.moveToFirst()){
			int id = c.getInt(c.getColumnIndex(StorageConstants.ID));
			String description = c.getString(c.getColumnIndex(StorageConstants.DESCRIPTION));
			String question = c.getString(c.getColumnIndex(StorageConstants.QUESTION));
			String answer = c.getString(c.getColumnIndex(StorageConstants.ANSWER));
			String searchTerms = c.getString(c.getColumnIndex(StorageConstants.SEARCH));
			int lat = c.getInt(c.getColumnIndex(StorageConstants.LATITUDE));
			int lon = c.getInt(c.getColumnIndex(StorageConstants.LONGITUDE));
			Location location = new Location("DataBase");
			location.setLatitude(lat);
			location.setLongitude(lon);
			e = new Event(description, question, answer, searchTerms, order, location);
		}
		
		db.close();
		dbh.close();
		
		return e;
	}
	
}

package net.mouluso.liverolehistory.storage;

import java.util.List;

import net.mouluso.liverolehistory.model.History;
import net.mouluso.liverolehistory.storage.constants.StorageConstants;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.android.maps.GeoPoint;

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
	
	
	public List<History> getHistorys(){
		DatabaseOpenHelper dbh = loadDBHelper(StorageConstants.DATABASE_NAME, StorageConstants.DATABASE_VERSION);
		SQLiteDatabase db = dbh.getReadableDatabase();
		
//		Cursor c = db.query(StorageConstants.TASK_TABLE, 
//				new String[]{StorageConstants.ID, StorageConstants.DESCRIPTION, StorageConstants.DATE, 
//							StorageConstants.DONE, StorageConstants.PRIORITY}, 
//				null, null, null, null, null);
//		
//		Task.getTasks().clear();
//		if(c.moveToFirst()){
//			do{
//				int id = c.getInt(c.getColumnIndex(StorageConstants.ID));
//				String description = c.getString(c.getColumnIndex(StorageConstants.DESCRIPTION));
//				String date = c.getString(c.getColumnIndex(StorageConstants.DATE));
//				boolean done = c.getInt(c.getColumnIndex(StorageConstants.DONE)) == StorageConstants.DONE_TRUE;
//				int priority = c.getInt(c.getColumnIndex(StorageConstants.PRIORITY));
//				
//				new Task(id, description, date, priority, done, false);
//			}while(c.moveToNext());
//		}else{
//			db.close();
//			dbh.close();
//			return false;
//		}
//		
//		db.close();
//		dbh.close();
//		return true;
		
		return null;
	}
	
	
	public void insertLocation(){
		DatabaseOpenHelper dbh = loadDBHelper(StorageConstants.DATABASE_NAME, StorageConstants.DATABASE_VERSION);
		SQLiteDatabase db = dbh.getWritableDatabase();
		
		ContentValues cv = new ContentValues();
		cv.put(StorageConstants.LATITUDE, 43333517);
		cv.put(StorageConstants.LONGITUDE, -8410678);
		db.insert(StorageConstants.LOCATION_TABLE, null, cv);
		
		db.close();
		dbh.close();
	}
	
	
	
	public GeoPoint getLocation(){
		DatabaseOpenHelper dbh = loadDBHelper(StorageConstants.DATABASE_NAME, StorageConstants.DATABASE_VERSION);
		SQLiteDatabase db = dbh.getReadableDatabase();
		
		Cursor c = db.query(StorageConstants.LOCATION_TABLE, 
				new String[]{StorageConstants.LATITUDE, StorageConstants.LONGITUDE}, 
				null, null, null, null, null);
		
		if(c.moveToFirst()){
			int lat = c.getInt(c.getColumnIndex(StorageConstants.LATITUDE));
			int lon = c.getInt(c.getColumnIndex(StorageConstants.LONGITUDE));
			
			db.close();
			dbh.close();
			return new GeoPoint(lat, lon);
		}
		
		db.close();
		dbh.close();
		return null;
	}
}

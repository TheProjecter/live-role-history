package net.mouluso.liverolehistory.storage;

import java.util.ArrayList;

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
	
	
	public void insertHistory(String name, String description, String image){
		DatabaseOpenHelper dbh = loadDBHelper(StorageConstants.DATABASE_NAME, StorageConstants.DATABASE_VERSION);
		SQLiteDatabase db = dbh.getWritableDatabase();
		
		ContentValues cv = new ContentValues();
		cv.put(StorageConstants.NAME, name);
		cv.put(StorageConstants.DESCRIPTION, description);
		cv.put(StorageConstants.IMAGE, image);
		
		db.insert(StorageConstants.HISTORY_TABLE, null, cv);
		
		db.close();
		dbh.close();
	}
	
	
	public ArrayList<History> getHistoryList(){
		DatabaseOpenHelper dbh = loadDBHelper(StorageConstants.DATABASE_NAME, StorageConstants.DATABASE_VERSION);
		SQLiteDatabase db = dbh.getReadableDatabase();
		
		Cursor c = db.query(StorageConstants.HISTORY_TABLE, 
				new String[]{StorageConstants.ID, StorageConstants.NAME, StorageConstants.DESCRIPTION, 
				StorageConstants.IMAGE}, null, null, null, null, null);
		
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
	
}

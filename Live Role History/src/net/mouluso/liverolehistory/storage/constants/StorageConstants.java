package net.mouluso.liverolehistory.storage.constants;

public class StorageConstants {
	public static final String DATABASE_NAME = "LiveRoleHistory";
	public static final int DATABASE_VERSION = 1;
	
	//DEBUGGING
	public static final String LOCATION_TABLE = "Location";
	public static final String LATITUDE = "Latitude";
	public static final String LONGITUDE = "Longitude";
	
	public static final String CREATE_LOCATION_TABLE = 
			"CREATE TABLE " + LOCATION_TABLE + "(" + 
					LATITUDE + " INTEGER," + 
					LONGITUDE + " INTEGER" +");";
	
	
	//----EXAMPLE
//	public static final String TASK_TABLE = "Task";
//	public static final String ID = "_id";
//	public static final String DESCRIPTION = "description";
//	public static final String DATE = "date";
//	public static final String PRIORITY = "priority";
//	public static final String DONE = "done";
//	
//	public static final String CREATE_TASK_TABLE = 
//			"CREATE TABLE " + TASK_TABLE + "(" + 
//					ID + " INTEGER PRIMARY KEY," + 
//					DESCRIPTION + " TEXT NOT NULL," +
//					DATE + " TEXT NOT NULL," +
//					PRIORITY + " INTEGER NOT NULL," +
//					DONE + " INTEGER NOT NULL" +
//			");";
	
	
}
